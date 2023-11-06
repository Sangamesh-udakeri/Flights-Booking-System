package com.project.exception;

public class RequiredSeatsNotAvailable extends RuntimeException {

	public RequiredSeatsNotAvailable(String message) {
		super(message);
	}
}
