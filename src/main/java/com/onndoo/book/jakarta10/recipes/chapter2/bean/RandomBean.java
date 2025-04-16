package com.onndoo.book.jakarta10.recipes.chapter2.bean;

import java.util.Random;

public class RandomBean {

	Random randomGenerator = new Random();
	private int randomNumber = 0;
	
	public int getRandomNumber() {
		randomNumber = randomGenerator.nextInt();
		return randomNumber;
	}
	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}
	
}
