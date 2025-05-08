package com.onndoo.book.jakarta10.recipes.chapter2.bean;

import java.io.Serializable;

public class Author implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String first;
	private String last;
	
	public Author() {
		id = -1;
		first = null;
		last = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
}
