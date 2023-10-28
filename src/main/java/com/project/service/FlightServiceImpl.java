package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Flight;
import com.project.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	FlightRepository flightRepository;
	@Override
	public Flight createFlight(Flight flight) {
		return flightRepository.save(flight);
	}

}
