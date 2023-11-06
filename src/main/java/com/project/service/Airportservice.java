package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.project.model.Airport;

public interface Airportservice {

	Airport addAirport(Airport airport);
	Airport updateAirport(Airport airport);
	Airport getAirport(Long id);
	List<Airport> getAirportsByCity(String city);
	
}
