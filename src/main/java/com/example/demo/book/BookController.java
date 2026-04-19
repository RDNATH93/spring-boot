package com.example.demo.book;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.author.Author;
import com.example.demo.author.AuthorRepository;

@Controller
class BookController {

	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	
	public BookController(BookRepository bookRepository,AuthorRepository authorRepository) {
		this.bookRepository=bookRepository;
		this.authorRepository=authorRepository;
	}
	
	//@SchemaMapping(typeName = "Query",field = "books")
	//@QueryMapping("books")
	@QueryMapping
	List<Book> books(){
		return bookRepository.findAll();
	}
	
	
	@QueryMapping
	Book book(@Argument("id")Long Id){
		return bookRepository.findById(Id).orElseThrow(()-> new RuntimeException ("Book not found"));
	}
	
	@MutationMapping
	Book addBook(@Argument BookInput book) {
		Author author = authorRepository.findById(book.authorId()).orElseThrow(()-> new RuntimeException ("Author not found"));
		Book addBook= new Book();
		addBook.setTitle(book.title());
		addBook.setAuthor(author);
		
		return bookRepository.save(addBook);
	}
	
	
}
