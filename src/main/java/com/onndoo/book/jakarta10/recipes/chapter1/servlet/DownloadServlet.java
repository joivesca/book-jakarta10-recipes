package com.onndoo.book.jakarta10.recipes.chapter1.servlet;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DownloadServlet", urlPatterns = {"/DownloadServlet"})
public class DownloadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileToDownload = req.getParameter("filename");
		
		System.err.println("Downloading file now...");
		
		doDownload(req, resp, fileToDownload);
	}
	
	private void doDownload(HttpServletRequest req, HttpServletResponse resp, String originalFile)
			throws IOException {
		
		final int BYTES = 1024;
		int length;
		
		ServletOutputStream out = resp.getOutputStream();
		ServletContext context = getServletConfig().getServletContext();
		
		resp.setContentType((context.getMimeType(originalFile) != null )
                ? context.getMimeType(originalFile) : "text/plain");
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + originalFile + "\"");

		InputStream in = context.getResourceAsStream("/" + originalFile);
		byte[] buffer = new byte[BYTES];
		while ((in != null) && ((length = in.read(buffer)) != -1)) {
			out.write(buffer, 0, length);
		}
		out.flush();
		out.close();		
	}
	
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "Short description";
	}

}
