package com.project.exception;

public class AirplaneNotFoundException extends RuntimeException {

	public AirplaneNotFoundException(String message) {
		super(message);
	}
}
