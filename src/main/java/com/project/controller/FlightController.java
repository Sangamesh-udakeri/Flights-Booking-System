package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.FlightRequest;
import com.project.model.Airplane;
import com.project.model.Airport;
import com.project.model.Flight;
import com.project.service.AirplaneService;
import com.project.service.Airportservice;
import com.project.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	FlightService flightService;
	@Autowired
	AirplaneService airplaneService;
	@Autowired
	Airportservice airportservice;
	
	@PostMapping("/flight/createflight")
	public ResponseEntity<Flight> createFlight(@RequestBody FlightRequest flightRequest){
		Airport arrivalAirport = airportservice.getAirport(flightRequest.getArrivalAirport());
		Airport departureAirport = airportservice.getAirport(flightRequest.getDepartureAirport());
		Airplane airplane = airplaneService.getAirplane(flightRequest.getAirplaneId());
		Flight flight =new Flight();
		flight.setFlightNumber(flightRequest.getFlightNumber());
		flight.setAirplane(airplane);
		flight.setArrivalAirport(arrivalAirport);
		flight.setDepartureAirport(departureAirport);
		flight.setArrivalTime(flightRequest.getArrivalTime());
		flight.setDepartureTime(flightRequest.getDepartureTime());
		flight.setFlightNumber(flightRequest.getFlightNumber());
		flight.setTotalSeats(flightRequest.getTotalSeats());
		flight.setCreatedAt(flightRequest.getCreatedAt());
		flight.setUpdatedAt(flightRequest.getUpdatedAt());
		Flight createFlight = flightService.createFlight(flight);
		return new ResponseEntity<Flight>(createFlight,HttpStatus.CREATED);
	}
}
