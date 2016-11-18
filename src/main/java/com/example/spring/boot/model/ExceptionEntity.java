package com.example.spring.boot.model;

public class ExceptionEntity {
	
	private String message;
	private int errorCode;
	private String url;

	public ExceptionEntity() {

	}

	public ExceptionEntity(String message, int errorCode, String url) {
		this.message = message;
		this.errorCode = errorCode;
		this.url = url;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
