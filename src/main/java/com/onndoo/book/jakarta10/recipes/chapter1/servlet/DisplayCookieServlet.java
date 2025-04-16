package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DisplayCookieServlet", urlPatterns = {"/DisplayCookieServlet"})
public class DisplayCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		
		Cookie[] cookies = request.getCookies();
		
		PrintWriter out = response.getWriter();
				
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Set Cookie</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>display Cookies</h1>");
			for(Cookie cookie: cookies) {
				out.println("<p>Cookie name: " + cookie.getName() + " Value: " + cookie.getValue() + "</h1>");
			}						
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
}
