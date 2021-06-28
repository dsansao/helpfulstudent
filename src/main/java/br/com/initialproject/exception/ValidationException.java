package br.com.initialproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ValidationException(String exception) {
		super(exception);
	}
	
}
