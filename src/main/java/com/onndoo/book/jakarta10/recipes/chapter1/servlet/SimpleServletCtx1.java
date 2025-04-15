package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="SimpleServletCtx1", urlPatterns = { "/SimpleServletCtx1" },
		initParams = { @WebInitParam(name = "name", value = "Duke") })
public class SimpleServletCtx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.printf("<html><head><title>Servlet SimpleServlet</title></head><body><p>Simple Servlet context to demonstrate! Hello %s </p></body></html>", getServletConfig().getInitParameter("name"));
		}
		
	}

}
