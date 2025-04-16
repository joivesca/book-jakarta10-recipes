package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SetCookieServlet", urlPatterns = {"/SetCookieServlet"})
public class SetCookieServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getServletInfo() {
		return "Set Cookie Servlet";
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie cookie = new Cookie("sessionId", "123456789");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(-30);
		response.addCookie(cookie);
		
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Set Cookie</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Cookie Set</h1>");
			out.println("<p>Cookie with name 'sessionId' has been set with value '123456789'.</p>");
			out.println("<br/><br/>");
			out.println("<a href=\"DisplayCookieServlet\">Display Cookie</a>");
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
