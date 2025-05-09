package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RedirectServlet", urlPatterns = {"/redirect"})
public class RedirectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public String getServletInfo() {
		return "Redirect Servlet";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String site = "https://www.apress.com";
		resp.sendRedirect(site);
	}

}
