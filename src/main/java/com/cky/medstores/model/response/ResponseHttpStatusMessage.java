package com.cky.medstores.model.response;

import org.springframework.http.HttpStatus;

/**
 * @author chandrakumar
 *
 */
public class ResponseHttpStatusMessage {
	public String getHttpStatusMessage(HttpStatus httpStatus){
		String message=null;
		
		// 200 
		if(httpStatus.value()==200){
			message = "OK, Successful.";	
		}
		else if(httpStatus.value()==201){
			message="The item was created successfully.";
		}

		// 300 
		else if(httpStatus.value()==304){
			message="Not modified.";
		}

		//400		
		else if(httpStatus.value()==400){
			message="Bad Request";
		}
		else if(httpStatus.value()==401){
			message="Unauthorized";
		}
		else if(httpStatus.value()==403){
			message="Forbidden";
		}
		else if(httpStatus.value()==404){
			message="Resource does not exist.";
		}
		// 500
		else if(httpStatus.value()>=500){
			message="Unknown Error.";
		}
		
		return message;
	}

}
