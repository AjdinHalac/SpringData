package com.bootcamp.spring.data.core.exceptionhandler.exceptions;

public class EmployerAlreadyExistsException extends RuntimeException{
    public EmployerAlreadyExistsException() {
        super();
    }

    public EmployerAlreadyExistsException(String message) {
        super(message);
    }
}
