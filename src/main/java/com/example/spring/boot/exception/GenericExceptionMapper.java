package com.example.spring.boot.exception;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
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
	protected ResponseEntity<ExceptionEntity> handleUnkownException(Exception ex, WebRequest request) throws URISyntaxException {
		// LOGGER.error(ex.getMessage(), ex);
		return handleException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
				new URI("https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html"));
	}
	@ExceptionHandler(value = { DataAccessException.class})
	protected ResponseEntity<ExceptionEntity> handleDataIntegrityViolationException(DataAccessException ex, WebRequest request) throws URISyntaxException {
		// LOGGER.error(ex.getMessage(), ex);
		return handleException(ex.getRootCause().getMessage() , HttpStatus.CONFLICT,
				new URI("http://studentRegistrationSystem/DataAccessException"));
	}

	@ExceptionHandler(value = { DuplicateResourceException.class })
	protected ResponseEntity<ExceptionEntity> handleDuplicateStudentException(Exception ex, WebRequest request) throws URISyntaxException {
		// LOGGER.error(ex.getMessage(), ex);
		return handleException(ex.getMessage(), HttpStatus.CONFLICT,
				new URI("http://studentRegistrationSystem/DuplicateResourceException"));
	}

	// handler for StudentNotFoundException thrown by the controller.
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	protected ResponseEntity<ExceptionEntity> handleNotFoundException(Exception ex, WebRequest request) throws URISyntaxException {
		// LOGGER.error(ex.getMessage(), ex);
		return handleException(ex.getMessage(), HttpStatus.NOT_FOUND,
				new URI("http://studentRegistrationSystem/ResourceNotFoundException"));
	}

	// common method for all exception categories.
	private ResponseEntity<ExceptionEntity> handleException(String message, HttpStatus status, URI uri) {
		// LOGGER.error(message);
		return new ResponseEntity<ExceptionEntity>(new ExceptionEntity(message, status.value(), uri.getRawPath()),
				status);
	}

}
