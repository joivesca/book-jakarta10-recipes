package com.onndoo.book.jakarta10.recipes.chapter3.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloWorldController {

	private String hello = "Hello World!";
	
	public String getHello() {
		return hello;
	}
	
	public void setHello(String hello) {
		this.hello = hello;
	}
}
