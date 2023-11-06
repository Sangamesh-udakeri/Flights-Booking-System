package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.AirportNotFoundException;
import com.project.model.Airport;
import com.project.repository.AirportRepository;

@Service
public class AirportServiceImpl implements Airportservice {

	@Autowired
	AirportRepository airportRepository;
	@Override
	public Airport addAirport(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	public Airport updateAirport(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	public Airport getAirport(Long id) {
		 Optional<Airport> findById = airportRepository.findById(id);
		 if(!findById.isPresent()) {
			 
			 throw new AirportNotFoundException("Could not find airport");
		 }
		 
		return findById.get();
	}

	@Override
	public List<Airport> getAirportsByCity(String city) {
		List<Airport> airportByCode = airportRepository.getAirportsByCity(city);
		return airportByCode;
	}

}
