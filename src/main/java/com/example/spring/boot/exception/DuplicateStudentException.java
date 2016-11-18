package com.example.spring.boot.exception;

import com.example.spring.boot.model.ExceptionEntity;

public class DuplicateStudentException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public DuplicateStudentException() {
	}

	public DuplicateStudentException(String errorMessage) {

		this.message = errorMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String errorMessage) {
		this.message = errorMessage;
	}

}
