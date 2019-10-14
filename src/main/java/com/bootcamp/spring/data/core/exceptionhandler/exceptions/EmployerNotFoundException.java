package com.bootcamp.spring.data.core.exceptionhandler.exceptions;

public class EmployerNotFoundException extends RuntimeException{
	public EmployerNotFoundException() {
		super();
	}

	public EmployerNotFoundException(String message) {
		super(message);
	}
}
