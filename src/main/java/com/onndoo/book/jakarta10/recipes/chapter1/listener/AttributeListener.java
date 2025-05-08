package com.onndoo.book.jakarta10.recipes.chapter1.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

//@WebListener
public class AttributeListener implements ServletContextListener, HttpSessionAttributeListener {

	private ServletContext context = null;
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		String id = session.getId();
		String name = event.getName();
		String value = (String) event.getValue();
		String message = new StringBuffer("New Attribute has been added to session: \n")
				.append("Attribute name: ").append(name).append("\n")
				.append(", Attribute Value: ").append(value).toString();
		log(message);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		String id = session.getId();
		String name = event.getName();
		if(name==null) {
			name = "Unknown";
		}
		String value = (String) event.getValue();
		String message = new StringBuffer("Attribute has been removed from session: \n")
				.append(id).append("\n")
				.append("Attribute name: ").append(name).append("\n")
				.append(", Attribute Value: ").append(value).toString();
		log(message);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name = event.getName();
		if(name==null) {
			name = "Unknown";
		}
		System.out.println("Attribute replaced: " + event.getName() + " = " + event.getValue());
		String value = (String) event.getValue();
		String message = new StringBuffer("Attribute has been replaces: \n")
				.append(name).toString();
		
		log(message);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		this.context = sce.getServletContext();
		log("context initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext destroyed");
	}
	
	private void log(String message) {
		if (context != null) {
			context.log("SessionListener: " + message);
		} else {
			System.out.println("SessionListener: " + message);
		}
	}

}
