package com.candidjava.springboot.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.candidjava.springboot.entity.Book;
import com.candidjava.springboot.service.BookService;

@Service
public class BookSeviceImpl implements BookService {
	


	static List<Book> bookList =new ArrayList<Book>();
	
	static
	{
		// add 3 users
		Book bookA= new Book((long) 1001001,"aaaa", "xxx", 2020,100);
		bookList.add(bookA);
		Book bookB= new Book((long) 1001002,"bbbb", "yyy", 2021,200);
		bookList.add(bookB);
		Book bookC= new Book((long) 1001003,"ccccc", "zzz", 2022,300);
		bookList.add(bookC);
	}
	
	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		bookList.add(book);
        return book;
	}

	@Override
	public Book updateBook(Long id, Book book) {
		// TODO Auto-generated method stub
		Book updateBook = null;
		for (Book bookFromList : bookList) {
			if(bookFromList.getId().equals(id)) {
				bookFromList.setTitle(book.getTitle());
				bookFromList.setAuthor(book.getAuthor());
				bookFromList.setPublicationYear(book.getPublicationYear());
				bookFromList.setPrice(book.getPrice());
				updateBook = bookFromList;
				break;
			}
		}
		return updateBook;
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookList;
	}

	@Override
	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		Optional<Book> bookById = 
				bookList.stream().
				filter(book -> book.getId().equals(id))
				.findFirst();
		if (bookById.isPresent()) {
			return bookById.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookList.removeIf(book -> book.getId().equals(id));
	}


}
