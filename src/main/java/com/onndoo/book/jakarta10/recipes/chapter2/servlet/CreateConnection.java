package com.onndoo.book.jakarta10.recipes.chapter2.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/jakarta";
	private static final String USER = "jakarta";
	private static final String PASSWORD = "Jakarta@1!";
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection established...");
		} catch (ClassNotFoundException e) {
			System.err.println("Error load driver. " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Error connect to database. " + e.getMessage());
		}
		
		return connection;
	}
}
