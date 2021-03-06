package com.cky.medstores.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * @author chandrakumar
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadRequestException(String message) {
        super(message);
    }
}
