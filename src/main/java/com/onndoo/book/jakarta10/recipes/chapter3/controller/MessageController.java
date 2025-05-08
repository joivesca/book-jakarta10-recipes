package com.onndoo.book.jakarta10.recipes.chapter3.controller;

import java.io.Serializable;
import java.util.Date;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@SessionScoped
public class MessageController implements Serializable{

	private static final long serialVersionUID = 1L;

	int hitCounter = 0;
	
	private String javaText;
	
	public int getHitCounter() {
		return hitCounter;
	}

	public void setHitCounter(int hitCounter) {
		this.hitCounter = hitCounter;
	}

	public String getJavaText() {
		return javaText;
	}

	public void setJavaText(String javaText) {
		this.javaText = javaText;
	}

	
	
	public MessageController() {
		javaText = null;
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Managed Bean Initialized", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}
	
	public void newMessage() {
		String hitMessage;
		hitCounter++;
		if(hitCounter > 1) {
			hitMessage = hitCounter + " times";
		} else {
			hitMessage = hitCounter + " time";
		}
		
		Date currDate = new Date();
		
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "You've pressed that button " + hitMessage + "! The current date and time: " + currDate, null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		
		FacesMessage javaTextMsg;
		
		if(getJavaText().equalsIgnoreCase("java")) {
			javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Good Job, that is the correct text!", null);
		} else {
			javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sorry, that is not the correct text!", null);	
		}
		
		FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
	}
}
