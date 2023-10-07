package com.candidjava.springboot.entity;

public class Book {
	
	
	public Book(Long id, String title, String author, int publicationYear, double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.price = price;
	}
	
	private Long id;
	private String title;
	private String author;
	private int publicationYear;
	private double price;;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


}
