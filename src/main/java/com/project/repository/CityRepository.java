package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.City;

public interface CityRepository  extends JpaRepository<City, Long> {

	
}
