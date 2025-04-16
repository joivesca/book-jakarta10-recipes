package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ReaderExample", urlPatterns = {"/ReaderExample"})
public class ReaderExample extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public String getServletInfo() {
		return "Reader Example Servlet";
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		String filename = "/WEB-INF/test.txt";
		ServletContext context = getServletContext();
		InputStream inputStream = context.getResourceAsStream(filename);
		
		try (PrintWriter out = response.getWriter()) {
			
			String path = "http://" +
			        request.getServerName() + ":" + request.getServerPort() + request.getContextPath()
			        + "/AcmeReaderServlet"; 
			out.println("<html><head><title>Intro to Jakarta 10</title></head><body>Reader Example at " + request.getContextPath() +" Invoking the endpoint : " + path);
			out.flush();
			
			URL url = new URL(path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setChunkedStreamingMode(2);
			connection.setDoOutput(true);
			connection.connect();
			
			if (inputStream != null) {
				
				InputStreamReader inputReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputReader);
				String text = "";
				out.println("<h1>Beginning read</h1>");
				
				try (BufferedWriter output = new BufferedWriter(
						new OutputStreamWriter(connection.getOutputStream()))) {
					out.println("got the output...beginnig loop");
					while ((text = bufferedReader.readLine()) != null) {
						out.println("Reading text: " + text);
						out.flush();
						output.write(text);
						Thread.sleep(1000);
						output.write("Ending example now...");
						output.flush();
					}
					output.flush();
					output.close();
				}										
			}
			out.println("Review the server log for messages...");						
			out.println("</body>");
			out.println("</html>");
		} catch (InterruptedException | IOException e) {
			Logger.getLogger(ReaderExample.class.getName()).log(Level.SEVERE, null, e);
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
