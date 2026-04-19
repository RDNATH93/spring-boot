package com.example.demo.search;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.author.Author;
import com.example.demo.author.AuthorRepository;
import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;

@Controller
class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	
	public SearchController(BookRepository bookRepository,AuthorRepository authorRepository) {
		this.bookRepository=bookRepository;
		this.authorRepository=authorRepository;
				
	}
	
	@QueryMapping
	List<Object> search(@Argument String text){
		logger.info("Searching for {}",text);
		var result=new ArrayList<>();
		
		result.addAll(authorRepository.findByNameContainsIgnoreCase(text));
		result.addAll(bookRepository.findByTitleContainsIgnoreCase(text));
		
		return result;
	}
}
