package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.dto.FlightRequest;
import com.project.dto.FlightResponse;
import com.project.dto.UserInput;
import com.project.model.Flight;

public interface FlightService {

	Flight createFlight(Flight flight);
	List<Flight> getAllFlights();
	Optional<Flight> getFlightById(Integer id);
	public List<FlightResponse> getFlightsByFilter(UserInput userInput);
}
