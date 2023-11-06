package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.FlightRequest;
import com.project.dto.FlightResponse;
import com.project.dto.SeatBook;
import com.project.dto.SeatData;
import com.project.dto.UserInput;
import com.project.exception.FlightNotFoundException;
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
	
	@GetMapping("/flights")
	public ResponseEntity<List<FlightResponse>> getFlights(){
		FlightResponse flightResponse=new FlightResponse();
		List<FlightResponse> flightResponses=new ArrayList<>();
		List<Flight> allFlights = flightService.getAllFlights();
		for(Flight flight:allFlights) {
			
			
			flightResponse.setArrivalAirport(flight.getArrivalAirport());
			flightResponse.setDepartureAirport(flight.getDepartureAirport());
			flightResponse.setArrivalAirportCity(flight.getArrivalAirport().getCity());
			flightResponse.setDepartureAirportCity(flight.getDepartureAirport().getCity());
			flightResponse.setArrivalTime(flight.getArrivalTime());
			flightResponse.setDepartureAirortCode(flight.getDepartureAirport().getCode());
			flightResponse.setArrivalAirortCode(flight.getDepartureAirport().getCode());
			flightResponse.setDepartureTime(flight.getDepartureTime());
			flightResponses.add(flightResponse);
		}
		return new ResponseEntity<List<FlightResponse>>(flightResponses,HttpStatus.OK);
	}
	
	@GetMapping("/flights/{id}")
	public ResponseEntity<FlightResponse> getById(@PathVariable  Long id) throws FlightNotFoundException{
		FlightResponse flightResponse=new FlightResponse();
	 Flight flight = flightService.getFlightById(id).get();
		if(flight==null) {
			
			throw new FlightNotFoundException("Could not find flight ");
		}
		
		flightResponse.setArrivalAirport(flight.getArrivalAirport());
		flightResponse.setDepartureAirport(flight.getDepartureAirport());
		flightResponse.setArrivalAirportCity(flight.getArrivalAirport().getCity());
		flightResponse.setDepartureAirportCity(flight.getDepartureAirport().getCity());
		flightResponse.setArrivalTime(flight.getArrivalTime());
		flightResponse.setPrice(flight.getPrice());
		flightResponse.setArrivalDate(flight.getArrivalDate());
		flightResponse.setDepartureDate(flight.getDepartureDate());
		flightResponse.setDepartureAirortCode(flight.getDepartureAirport().getCode());
		flightResponse.setArrivalAirortCode(flight.getDepartureAirport().getCode());
		flightResponse.setDepartureTime(flight.getDepartureTime());
		
		return new ResponseEntity<FlightResponse>(flightResponse,HttpStatus.OK);
	}
	@PostMapping("/flight")
	public ResponseEntity< List<FlightResponse>> getFlightsByFilter(@RequestBody UserInput userInput ) {
	    List<FlightResponse> flightsByFilter = flightService.getFlightsByFilter(userInput);
	    return new ResponseEntity<>(flightsByFilter, HttpStatus.OK);
	}
	@PutMapping("/updateSeats")
	public ResponseEntity< String> updateSeats(@RequestBody SeatData data) {
	    String updateSeats = flightService.updateSeats(data);
	    return new ResponseEntity<>(updateSeats, HttpStatus.OK);
	}
	
}
