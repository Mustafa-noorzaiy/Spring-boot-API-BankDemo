package com.bank.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This class says NO found if there is no data in database if exception happen

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundEception extends RuntimeException {

	private static final long serialVersionUID =1L;
	
	public ResourceNotFoundEception(String message) {
		super(message);
	}
	
	
	
	
	
	
}
