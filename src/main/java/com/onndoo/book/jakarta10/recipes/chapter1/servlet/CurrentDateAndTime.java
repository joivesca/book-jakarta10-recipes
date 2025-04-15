package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CurrentDateAndTime", urlPatterns = { "/CurrentDateAndTime" })
public class CurrentDateAndTime extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	Date currDateAndTime = new Date();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
       
		synchronized (currDateAndTime) {
			currDateAndTime = new Date();
		}
		
        try (PrintWriter out = response.getWriter()) {
            out.printf("<html><head><title>Servlet Current Date and Time</title></head><body><h1>Current Date and Time at %s</h1><br/>The current date and time  is: %s</body></html>", request.getContextPath(), currDateAndTime);
        }
        
        response.getWriter().println("<h1>" + currDateAndTime + "</h1>");
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
