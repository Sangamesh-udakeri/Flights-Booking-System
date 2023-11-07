package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.SignUp;
import com.project.service.SignUpService;

@RestController
public class SignUpController {

	@Autowired
	SignUpService signUpService;

	@PostMapping("/signup")
	public ResponseEntity<SignUp > createUser(SignUp signUp){
		SignUp signUpUser = signUpService.signUpUser(signUp);
		return new ResponseEntity<SignUp>(signUpUser,HttpStatus.CREATED);
	}
}
