package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MathServlet", urlPatterns = { "/MathServlet" })
public class MathServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String numA = request.getParameter("numa");
		String numB = request.getParameter("numb");
		int solution = 0;
		
		try (PrintWriter out = response.getWriter()) {
			try {
				System.out.println("numA: " + numA);
				System.out.println("numB: " + numB);
				
				solution = Integer.valueOf(numA) + Integer.valueOf(numB);
				System.out.println("solution: " + solution);
			} catch (NumberFormatException e) {
				out.println("Please use numbers only...try again.");
				return;
			}
			out.printf("<html><head><title>MathServlet</title></head><body>Solution: %s + %s = %d <br/><a href='recipe01_06.html'>Add Two more numbers</a></body></html>", numA, numB, solution);
		}
	}
}
