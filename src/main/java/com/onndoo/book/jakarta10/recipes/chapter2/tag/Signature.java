package com.onndoo.book.jakarta10.recipes.chapter2.tag;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class Signature extends SimpleTagSupport {
	
	private String authorName = null;
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		
		try {
			if(authorName != null ) {
				out.println("Written by " + authorName);
				out.println("<br/>");
			}
			out.println("Published by Apress");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
