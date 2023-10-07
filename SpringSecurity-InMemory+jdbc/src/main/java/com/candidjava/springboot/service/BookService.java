package com.candidjava.springboot.service;

import java.util.List;

import com.candidjava.springboot.entity.Book;

public interface BookService {


	public Book createBook(Book book);

	public Book updateBook(Long id, Book book);

	public List<Book> getBooks();

	public Book getBookById(Long id);

	public void deleteBook(Long id);

}
