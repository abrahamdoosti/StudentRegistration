package com.example.spring.boot.exception;

public class ResourceNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public ResourceNotFoundException() {
		
	}
	
	@SuppressWarnings("rawtypes")
	public ResourceNotFoundException(Class targetClass) {
		if(targetClass != null){
			this.message = targetClass.getSimpleName() +  " Not Found";
		}
	}

	public ResourceNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
