package com.onndoo.book.jakarta10.recipes.chapter3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named(value = "authorController")
@SessionScoped
public class AuthorController implements Serializable{

	private static final long serialVersionUID = 1L;

	private String newAuthorFirst;
	private String newAuthorLast;
	private String bio;
	
	private List<Author> authorList;
	
	public AuthorController() {
		populateAuthorList();
	}
	
	private void populateAuthorList() {
		System.out.println("Initializing authors");
		authorList = new ArrayList<>();
		authorList.add(new Author("Josh", "Juneau", null));
		authorList.add(new Author("Tarung", "Telang", null));
		System.out.println("Size: " + authorList.size());
	}
	
	public void addAuthor() {
		getAuthorList().add(new Author(this.getNewAuthorFirst(), this.getNewAuthorLast(), this.getBio()));
	}

	public String getNewAuthorFirst() {
		return newAuthorFirst;
	}

	public void setNewAuthorFirst(String newAuthorFirst) {
		this.newAuthorFirst = newAuthorFirst;
	}

	public String getNewAuthorLast() {
		return newAuthorLast;
	}

	public void setNewAuthorLast(String newAuthorLast) {
		this.newAuthorLast = newAuthorLast;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}
	
	
}
