package com.project.exception;

public class AirportNotFoundException extends RuntimeException {

	public AirportNotFoundException(String message) {
		super(message);
	}
}
