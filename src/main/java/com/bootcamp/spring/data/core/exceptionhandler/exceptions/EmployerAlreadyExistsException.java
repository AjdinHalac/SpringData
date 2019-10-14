package com.bootcamp.spring.data.core.exceptionhandler.exceptions;

public class TenantAlreadyExistsException extends RuntimeException{
    public TenantAlreadyExistsException() {
        super();
    }

    public TenantAlreadyExistsException(String message) {
        super(message);
    }
}
