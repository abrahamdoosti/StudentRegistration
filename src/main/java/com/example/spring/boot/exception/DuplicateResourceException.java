package com.example.spring.boot.exception;

public class DuplicateResourceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public DuplicateResourceException() {
	}

	public DuplicateResourceException(String errorMessage) {

		this.message = errorMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String errorMessage) {
		this.message = errorMessage;
	}

}
