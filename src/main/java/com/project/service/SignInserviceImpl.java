package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.EmailAlreadyUsed;
import com.project.exception.NotRegisteredUser;
import com.project.model.SignIn;
import com.project.repository.SignInRepository;

@Service
public class SignInserviceImpl implements SignInService {

	
	@Autowired
	SignInRepository signInRepository;
	
	@Override
	public String signIn(SignIn in) {
		SignIn findByEmail = signInRepository.findByEmail(in.getEmail());
		if(findByEmail==null) {
			throw new NotRegisteredUser("User not registerd");
		}else if(findByEmail.getEmail().equals(in.getEmail()) && findByEmail.getPassword().equals(in.getPassword())) {
			return "signed-in";
		}
		return "Enter correct user details";
	}

}
