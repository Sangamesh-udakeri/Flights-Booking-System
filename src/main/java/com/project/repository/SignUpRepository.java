package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.SignUp;
import java.util.List;


public interface SignUpRepository extends JpaRepository<SignUp , Long> {

	SignUp findByEmail(String email);
}
