package com.example.spring.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.spring.boot.model.ExceptionEntity;

@ControllerAdvice
public class GenericExceptionMapper extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<ExceptionEntity> handleUnkownException(Exception ex, WebRequest request) {
		// LOGGER.error(ex.getMessage(), ex);

		return new ResponseEntity<ExceptionEntity>(new ExceptionEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "www.student.com"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { DuplicateResourceException.class })
	protected ResponseEntity<ExceptionEntity> handleDuplicateStudentException(Exception ex, WebRequest request) {
		 //LOGGER.error(ex.getMessage(), ex);
		return handleException(ex.getMessage(), HttpStatus.CONFLICT);
	}	
	
	//handler for StudentNotFoundException thrown by the controller.
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	protected ResponseEntity<ExceptionEntity> handleNotFoundException(Exception ex, WebRequest request) {
		 //LOGGER.error(ex.getMessage(), ex);
		return handleException(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

   //common method for all exception categories.
	private ResponseEntity<ExceptionEntity> handleException(String message, HttpStatus status) {
		//LOGGER.error(message);
		return new ResponseEntity<ExceptionEntity>(new ExceptionEntity(message,status.value(),"www.student.com"), status);
	}

}
