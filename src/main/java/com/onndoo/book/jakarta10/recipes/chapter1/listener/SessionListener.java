package com.onndoo.book.jakarta10.recipes.chapter1.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

	private int numberOfSessions;
	
	public SessionListener() {
		numberOfSessions = 0;
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		HttpSession session = se.getSession();
		session.setMaxInactiveInterval(60);
		session.setAttribute("testAttr", "testVal");
		
		synchronized (this) {
			numberOfSessions++;
		}
		
		System.out.println("Session created, current count: " + numberOfSessions);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		HttpSession session = se.getSession();
		synchronized (this) {
			numberOfSessions--;
		}
		System.out.println("Session destroyed, current count: " + numberOfSessions);
		System.out.println("The attribute value: " + session.getAttribute("testAttr"));
	}
	
}
