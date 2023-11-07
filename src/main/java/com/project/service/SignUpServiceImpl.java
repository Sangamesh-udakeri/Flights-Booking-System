package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.EmailAlreadyUsed;
import com.project.model.SignIn;
import com.project.model.SignUp;
import com.project.repository.SignInRepository;
import com.project.repository.SignUpRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	SignUpRepository signUpRepository;
	@Autowired
	SignInRepository signInRepository;
	@Override
	public SignUp signUpUser(SignUp signUp) {
		
		if(signUpRepository.findByEmail(signUp.getEmail())!=null) {
			 throw new EmailAlreadyUsed("Email is already in use");
		}
	
		SignIn in=new SignIn();
		in.setEmail(signUp.getEmail());
		in.setPassword(signUp.getPassword());
		signInRepository.save(in);
		return signUpRepository.save(signUp);
	}

}
