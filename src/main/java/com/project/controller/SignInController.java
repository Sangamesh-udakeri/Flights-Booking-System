package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.SignIn;
import com.project.model.SignUp;
import com.project.service.SignInService;

@RestController
public class SignInController {

	@Autowired
	SignInService signInService;
	
	@PostMapping("/signin")
	public ResponseEntity<String > createUser(SignIn in){
		String signIn = signInService.signIn(in);
		return new ResponseEntity<String>(signIn,HttpStatus.CREATED);
	}
}
