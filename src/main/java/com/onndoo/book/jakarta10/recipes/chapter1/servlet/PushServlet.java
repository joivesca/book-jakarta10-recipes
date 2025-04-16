package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.onndoo.book.jakarta10.recipes.chapter1.listener.AcmeReadListenerImpl;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

@WebServlet(name = "PushServlet", urlPatterns = {"/PushServlet"})
public class PushServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			out.printf("<html><head><title>Push Servlet</title></head><body><h1>Servlet Push at %s!</h1><img src=\"./resources/images/jakartaee10recipes.png\"/</body></html>", request.getContextPath());
		} 
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In the servlet");
		
		if (req.getRequestURI().contains("PushServlet") && req.newPushBuilder() != null) {
			System.out.println("In the Push Servlet");
			PushBuilder builder = req.newPushBuilder().path("/resources/images/jakartaee10recipes.png");
			builder.path("/resources/images/jakartaee10recipes.png");
			builder.push();
		}
		processRequest(req, resp);
		
	}
}
