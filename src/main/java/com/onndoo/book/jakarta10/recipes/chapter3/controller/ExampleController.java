package com.onndoo.book.jakarta10.recipes.chapter3.controller;

import java.util.ResourceBundle;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;


@Named(value = "exampleController")
@RequestScoped
public class ExampleController {

	private String exampleProperty;

	public ExampleController() {
		exampleProperty = "Used to instantiate the bean.";
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				ResourceBundle.getBundle("Bundle").getString("ExampleMessage"), null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public String getExampleProperty() {
		return exampleProperty;
	}

	public void setExampleProperty(String exampleProperty) {
		this.exampleProperty = exampleProperty;
	}

}
