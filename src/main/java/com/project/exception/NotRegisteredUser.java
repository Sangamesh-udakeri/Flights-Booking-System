package com.project.exception;

public class NotRegisteredUser extends RuntimeException {

	public NotRegisteredUser(String message) {
	
		super(message);
	}
}
