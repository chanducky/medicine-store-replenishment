package com.cky.medstores.model.response;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.http.HttpStatus;

/**
 * @author chandrakumar
 *
 */

public class ResponseErrorMessage extends ResponseHttpStatusMessage{
	int code;
	String message;
	Collection<?> errors;

	public ResponseErrorMessage(HttpStatus httpStatus) {
		super();
		constructorHelper(httpStatus);
	}

	public ResponseErrorMessage(int errorCode,String message) {
		super();
		this.code=errorCode;
		this.message=message;
	}
	
	public ResponseErrorMessage(HttpStatus httpStatus,String error) {
		super();
		LinkedList<String> errorList= new LinkedList<>();
		errorList.add(error);
		this.errors =errorList;
		constructorHelper(httpStatus);
	}

	public ResponseErrorMessage(HttpStatus httpStatus,Collection<?> errors) {
		super();
		this.errors =errors;
		constructorHelper(httpStatus);
	}

	private void constructorHelper(HttpStatus httpStatus){
		this.code=httpStatus.value();
		this.message=getHttpStatusMessage(httpStatus);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Collection<?> getErrors() {
		return errors;
	}

	public void setErrors(Collection<?> errors) {
		this.errors = errors;
	}

}
