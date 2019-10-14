package com.bootcamp.spring.data.core.exceptionhandler;

import com.bootcamp.spring.data.core.exceptionhandler.exceptions.EmployerNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ExceptionResponse handleIllegalArgumentException(IllegalArgumentException e) {
		return new ExceptionResponse(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployerNotFoundException.class)
	public ExceptionResponse handleEmployerNotFound(EmployerNotFoundException e){
		return new ExceptionResponse(HttpStatus.NOT_FOUND, e.getMessage());
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ExceptionResponse handleDataIntegrityViolationException(DataIntegrityViolationException e){
		return new ExceptionResponse(HttpStatus.CONFLICT, e.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ExceptionResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		return new ExceptionResponse(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ExceptionResponse handleDefaultException(Exception e){
		return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}
}
