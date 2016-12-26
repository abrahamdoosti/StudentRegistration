package com.example.spring.boot.exception;

public class DataMismatchException extends Exception {
	private static final long serialVersionUID = 1L;

	private String message;

	public DataMismatchException() {

	}

	@SuppressWarnings("rawtypes")
	public DataMismatchException(Class targetClass) {
		if (targetClass != null) {
			this.message = targetClass.getSimpleName() + " Not Found";
		}
	}

//	@SuppressWarnings("rawtypes")
//	public DataMismatchException(Class targetClass, String... data) {
//		StringBuilder stBuilder = new StringBuilder();
//		if (targetClass != null) {
//			for (String s : data) {
//				if (s.equals(data[data.length - 2]))
//					stBuilder.append(s + " and ");
//				if (s.equals(data[data.length - 1]))
//					stBuilder.append(s);
//				else
//					stBuilder.append(s + " , ");
//			}
//			
//			this.message = targetClass.getSimpleName()+stBuilder.toString() + " Do Not Match!";
//
//		}
//		
//	}

	public DataMismatchException(String errorMessage) {
		this.message = errorMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
