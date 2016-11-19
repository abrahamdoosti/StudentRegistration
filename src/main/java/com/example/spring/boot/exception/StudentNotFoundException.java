package com.example.spring.boot.exception;

public class StudentNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public StudentNotFoundException() {
		
	}

	public StudentNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
