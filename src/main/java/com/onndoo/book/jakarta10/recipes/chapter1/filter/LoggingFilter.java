package com.onndoo.book.jakarta10.recipes.chapter1.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/*" })
public class LoggingFilter implements Filter{

	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String userIP = request.getRemoteHost();
		System.out.println("Visitor user IP: " + userIP);
		chain.doFilter(request, response);		
	}
	
	@Override
	public void destroy() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
