package com.cky.medstores.model.response;

import org.springframework.http.HttpStatus;

/**
 * @author chandrakumar
 *
 */

public class ResponseSuccessMessage extends ResponseHttpStatusMessage{
	int code;
	String message;
	Object data;

	public ResponseSuccessMessage(HttpStatus httpStatus) {
		super();
		constructorHelper(httpStatus);
	}

	public ResponseSuccessMessage(HttpStatus httpStatus, Object data) {
		super();
		this.data=data;
		constructorHelper(httpStatus);
	}

	public ResponseSuccessMessage(int errorCode,String message) {
		super();
		this.code=errorCode;
		this.message=message;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
