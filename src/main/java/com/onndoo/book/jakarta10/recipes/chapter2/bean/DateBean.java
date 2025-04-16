package com.onndoo.book.jakarta10.recipes.chapter2.bean;

import java.util.Date;

public class DateBean {

	private Date currentDate = new Date();
	
	public Date getCurrentDate() {
		return currentDate;
	}
	
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
}
