package io.egen.api_module.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Rating cannot be null and must be between 1 and 5")
public class MissingRatingDetailsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8823038177660428135L;
	
	public MissingRatingDetailsException(String msg){
		super(msg);
	}
	
	public MissingRatingDetailsException(String msg, Throwable cause){
		super(msg, cause);
	}
	
}
