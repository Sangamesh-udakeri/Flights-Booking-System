package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.dto.FlightRequest;
import com.project.dto.FlightResponse;
import com.project.dto.SeatBook;
import com.project.dto.SeatData;
import com.project.dto.UserInput;
import com.project.model.Flight;

public interface FlightService {

	Flight createFlight(Flight flight);
	List<Flight> getAllFlights();
	Optional<Flight> getFlightById(Long id);
	public List<FlightResponse> getFlightsByFilter(UserInput userInput);
	public String updateSeats(SeatData seatData);
}
