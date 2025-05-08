package com.onndoo.book.jakarta10.recipes.chapter2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RecipeServlet", urlPatterns = {"/RecipeServlet"})
public class RecipeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		int result = -1;
		
		try {
			result = insertRow(request.getParameter("recipeNumber"),
					request.getParameter("name"),
					request.getParameter("description"),
					request.getParameter("text"));
			
			out.println("<html><head><title>Servlet RecipeServlet</title></head><body>");
			out.printf("<h1>Servlet RecipeServlet at " + request.getContextPath() + "</h1>");
			out.println("<br/><br/>");
			
			if(result > 0) {
				out.println("<font color='green'>Record successfully inserted!</font><br/><br/>");
				out.println("<a href='chapter02/recipe02_11.jspx'>Insert another record<a/>");
			} else {
				out.println("<font color='red'>Record not inserted!</font><br/><br/>");
				out.println("<a href='chapter02/recipe02_11.jspx'>Try again<a/>");
			}
			out.println("</body>");
			out.println("</html>");			
		} finally {
			out.close();
		}
						
	}
	
	public int insertRow(String recipeNumber, String name, String description, String text) {
		
		String sql = "INSERT INTO recipe VALUES(?, ?, ?, ?)";
		PreparedStatement stmt = null;
		int result = -1;
		
		try {
			
			Connection conn = CreateConnection.getConnection();			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recipeNumber);
			stmt.setString(2, name);
			stmt.setString(3, description);
			stmt.setString(4, text);
			
			result = stmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("-- Record created --");
			} else {
				System.out.println("!! Record NOT created !!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null ) {
				try {
					stmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		return result;
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
