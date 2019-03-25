//this is like POJO class


package com.example.spring.core;

public class Greetings {
	private String message = "Spring Hello World!!";

	public void getMessage() {
		//return message;
		System.out.println(message);
	}

	public void setMessage(String message) {
		this.message = message;
		
	}
	
}
