package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.SignIn;

public interface SignInRepository  extends JpaRepository<SignIn, Long>{

	SignIn findByEmail(String email);
}
