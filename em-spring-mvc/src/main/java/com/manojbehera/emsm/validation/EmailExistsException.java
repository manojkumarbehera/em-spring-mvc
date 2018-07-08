package com.manojbehera.emsm.validation;

public class EmailExistsException extends RuntimeException {

	public EmailExistsException(final String message) {
		super(message);
	}
}
