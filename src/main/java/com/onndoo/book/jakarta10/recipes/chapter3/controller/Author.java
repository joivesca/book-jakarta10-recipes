package com.onndoo.book.jakarta10.recipes.chapter3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String first;
	private String last;
	private String bio;
	private List<Book> books;
		
	public Author(String first, String last, String bio) {
		this.first = first;
		this.last = last;
		this.bio = bio;
		this.books = new ArrayList<>();
	}
	
	
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public List<Book> getBooks() {
        return books;
    }
	
	public void addBook(Book book) {
        books.add(book);
    }
}
