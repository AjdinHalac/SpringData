package com.bootcamp.spring.data.core.exceptionhandler.exceptions;

public class OfficeNotFoundException extends RuntimeException{
    public OfficeNotFoundException() {
        super();
    }

    public OfficeNotFoundException(String message) {
        super(message);
    }
}
