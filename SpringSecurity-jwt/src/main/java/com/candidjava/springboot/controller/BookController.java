package com.candidjava.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidjava.springboot.entity.Book;
import com.candidjava.springboot.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	//Create Book
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	//Update Book
	@PutMapping
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	//Get all books
	@GetMapping
	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	//Get Book By Id
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}

	
	//Delete Book
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}

}
