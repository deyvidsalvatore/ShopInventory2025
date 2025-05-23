package com.deyvidsalvatore.shopinventory_api.domain.exceptions;

import java.io.Serial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		super("Resource with this ID was not found");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
