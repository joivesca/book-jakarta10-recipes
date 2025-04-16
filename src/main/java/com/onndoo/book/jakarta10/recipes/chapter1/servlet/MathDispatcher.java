package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MathDispatcher", urlPatterns = {"/MathDispatcher"})
public class MathDispatcher extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In the servlet...");
		
		String eval = req.getParameter("eval");
		
		ServletContext sc = getServletConfig().getServletContext();
		RequestDispatcher rd = null;
		
		switch (eval) {
			case "add":
                rd = sc.getRequestDispatcher("/AddServlet");
                break;
			case "subtract": 
                rd = sc.getRequestDispatcher("/SubtractServlet");
                break;
			case "multiply":
				rd = sc.getRequestDispatcher("/MultiplyServlet");
                break;
			case "divide":
				rd = sc.getRequestDispatcher("/DivideServlet");
                break;
		}
		
		rd.forward(req, resp);

	}
	
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "Short description";
	}
}
