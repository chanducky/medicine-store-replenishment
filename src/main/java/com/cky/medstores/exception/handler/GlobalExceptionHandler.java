package com.cky.medstores.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cky.medstores.exception.BadRequestException;
import com.cky.medstores.model.response.ResponseErrorMessage;

/**
 * @author chandrakumar
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status,WebRequest request) {
		ResponseErrorMessage error = new ResponseErrorMessage(status);
		return new ResponseEntity<Object>(error, status);
	}
	
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		ResponseErrorMessage error = new ResponseErrorMessage(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadRequestException.class)
	protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
		ResponseErrorMessage error = new ResponseErrorMessage(HttpStatus.BAD_REQUEST,ex.getMessage());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ResponseErrorMessage error = new ResponseErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
