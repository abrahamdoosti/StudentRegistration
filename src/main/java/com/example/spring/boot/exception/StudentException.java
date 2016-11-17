package com.example.spring.boot.exception;

public class StudentException extends Exception {

	private String message;

	public StudentException() {

	}

	public StudentException(String message) {

		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
