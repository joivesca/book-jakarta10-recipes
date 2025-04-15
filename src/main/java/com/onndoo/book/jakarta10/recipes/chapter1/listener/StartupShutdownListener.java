package com.onndoo.book.jakarta10.recipes.chapter1.listener;

import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class StartupShutdownListener implements ServletContextListener {

	private final String TAG = "StartupShutdownListener";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(TAG + "Servlet startup...");
		System.out.println(TAG + sce.getServletContext().getServerInfo());
		System.out.println(TAG + System.currentTimeMillis());
		// Perform startup tasks here
		sendEmail("ServletContext has initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println(TAG + "Servlet shutdown...");
		System.out.println(TAG + sce.getServletContext().getServerInfo());
		System.out.println(TAG + System.currentTimeMillis());
		
		sendEmail("ServletContext has been destroyed");
	}
	
	private void sendEmail(String message) {
		String smtpHost = "localhost"; // Replace with your SMTP host
		String smtpUser = "user"; // Replace with your SMTP user
		String smtpPassword = "password"; // Replace with your SMTP password
		String from = "fromaddress@localhost.com";
		String to = "toaddress@localhost.com";
		int smtpPort = 25; // Replace with your SMTP port
		
		System.out.println(TAG + "Sending email from " + from + " to " + to);
		
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", smtpHost);
			props.put("mail.smtp.port", smtpPort);
			props.put("mail.smpt.auth", "false");
			props.put("mail.smtp.starttls.enable", "false");
			
			Session session = Session.getInstance(props);
			
			Message msg = new MimeMessage(session);
			
			InternetAddress addressFrom = new InternetAddress(from);
			msg.setFrom(addressFrom);
			InternetAddress[] address = new InternetAddress[1];
			address[0] = new InternetAddress(to);
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(TAG + "ServletContext shutting down");
						
			msg.setContent(message, "text/plain");
			Transport transport = session.getTransport("smtp");
			transport.connect(smtpHost, smtpPort, smtpUser, smtpPassword);
			Transport.send(msg, smtpUser, smtpPassword);						
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println(TAG + "Error sending email: " + e.getMessage());
		}
		System.out.println(TAG + "email successfully sent");
	}

}
