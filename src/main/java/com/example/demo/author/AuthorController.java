package com.example.demo.author;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;
 
@Controller
class AuthorController {

	private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	public AuthorController(AuthorRepository authorRepository,BookRepository bookRepository) {
		this.authorRepository=authorRepository;
		this.bookRepository=bookRepository;
	}
	
	@QueryMapping
	List<Author>authors(){
		return authorRepository.findAll(); 
	}
	
//	@SchemaMapping
//	List<Book>books(Author author) throws InterruptedException{
//		logger.info("Fetching Books of Auhtor {}",author.getName());
//		Thread.sleep(1000);
//		return new ArrayList<>();
//	}
	
	@BatchMapping
	List<List<Book>>books(List<Author>authors){
		logger.info("Fetching books for {}",authors.size());
		
		List<Long> authorIds = authors.stream().map(author->author.getId()).toList();
		
		List<Book> allBooks = bookRepository.findByAuthorIdIn(authorIds);
		
		Map<Long, List<Book>> booksByAuthorId = allBooks.stream()
		.collect(Collectors.groupingBy(book->book.getAuthor().getId()));
		
		 return authors.stream()
		       .map(author->booksByAuthorId.getOrDefault(author.getId(), Collections.emptyList()))
		       .toList();
		
	}
	
	
}
