package com.server.tools.exceptions;

import org.springframework.validation.Errors;

public class UsernameInvalidException extends RuntimeException {
	private Errors errors;

	public UsernameInvalidException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public UsernameInvalidException(String message) {
		super(message);
	}

	public Errors getErrors() { return errors; }
}

