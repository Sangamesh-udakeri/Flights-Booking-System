package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dto.UserInput;
import com.project.model.Flight;

public interface FlightRepository extends JpaRepository<com.project.model.Flight, Integer> {

	

}
