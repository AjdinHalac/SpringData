package com.bootcamp.spring.data.core.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	public int code;
	public String message;
	public String developerMessage;

	ExceptionResponse(HttpStatus status, String developerMessage){
		this.code = status.value();
		this.message = status.getReasonPhrase();
		this.developerMessage = developerMessage;
	}
}
