package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		String email = (String) session.getAttribute("session.email");
		
		if (email == null) {
			email = req.getParameter("email");
			session.setAttribute("session.email", email);
		}
		
		String sessionId = session.getId();
		
		resp.setContentType("text/html");
		
		try (PrintWriter out = resp.getWriter()) {
			out.println("<html>");
			out.println("<head><title>Working with Sessions</title></head>");
			out.println("<body>");
			out.println("<h1>Session Test</h1>");
			out.println("<p>Email: " + email + "</p>");
			out.println("<p>Session ID: " + sessionId + "</p>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
