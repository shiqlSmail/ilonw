package com.server.tools.exceptions;

import org.springframework.validation.Errors;

public class ReloginException extends RuntimeException {
	private Errors errors;

	public ReloginException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public ReloginException(String message) {
		super(message);
	}

	public Errors getErrors() { return errors; }
}
