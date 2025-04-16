package com.onndoo.book.jakarta10.recipes.chapter2.bean;

import java.io.Serializable;

public class EasyBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fieldValue;
	
	public EasyBean() {
		fieldValue = null;
	}
	
	public String getFieldValue() {
		return fieldValue;
	}
	
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
}
