package com.example.Dbever.controller;

public class Hellowbean {

	private String message;

	public Hellowbean(String string) {
		this.message=string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Hellowbean [message=" + message + "]";
	}
	
	
	
	

	
	

}
