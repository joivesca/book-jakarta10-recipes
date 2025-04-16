package com.onndoo.book.jakarta10.recipes.chapter1.listener;

import java.io.IOException;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;

public class WriteListenerImpl implements WriteListener{

	ServletOutputStream os;
	AsyncContext context;
	
	public WriteListenerImpl(ServletOutputStream os, AsyncContext context) {
		this.os = os;
		this.context = context;
		System.out.println("Write Listener initialized");
	}
	
	@Override
	public void onWritePossible() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("Error ocurred:" + t);
		context.complete();	
	}

}
