package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private String message;
	
	@Override
	public void init() {
        message = "Welcome to Jakarta EE 10 Recipes";
    }
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.printf("<html><head><title>Servlet SimpleServlet</title></head><body><h2>Simple Servlet at %s</h2><br/>%s</body></html>", request.getContextPath(), message);
		}
		
		response.getWriter().println("<h1>" + message + "</h1>");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
