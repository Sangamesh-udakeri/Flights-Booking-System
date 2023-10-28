package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AirportRequest;
import com.project.exception.CityNotFoundException;
import com.project.model.Airport;
import com.project.model.City;
import com.project.service.AirplaneService;
import com.project.service.Airportservice;
import com.project.service.CityService;

@RestController
public class AirportController {

	@Autowired
	Airportservice airportservice;
	@Autowired
	CityService cityService;

	@PostMapping("/addAirport")
	public ResponseEntity<Airport> addAirport(@RequestBody AirportRequest airportRequest) throws CityNotFoundException {
		City city = cityService.getCity(airportRequest.getCityId());
		Airport airport = new Airport();
		airport.setName(airportRequest.getName());
		airport.setCode(airportRequest.getCode());
		airport.setAddress(airportRequest.getAddress());
		airport.setCity(city);
		Airport addAirport = airportservice.addAirport(airport);
		return new ResponseEntity<Airport>(addAirport,HttpStatus.CREATED);
	}

	@PutMapping("/updateAirport")
	public ResponseEntity<Airport> updateAirport(@RequestBody Airport airport) {
		Airport updateAirport = airportservice.updateAirport(airport);
		return new ResponseEntity<Airport>(updateAirport, HttpStatus.OK);
	}

	@GetMapping("/getAirportById/{id}")
	public ResponseEntity<Airport> getAirport(@PathVariable Integer id) {
		Airport airport = airportservice.getAirport(id);
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
	}

	@GetMapping("/getAirportByCity/{city}")
	public ResponseEntity<List<Airport>> getAirportsByCity(@PathVariable String city) {
		List<Airport> airportsByCity = airportservice.getAirportsByCity(city);
		return new ResponseEntity<List<Airport>>(airportsByCity, HttpStatus.OK);
	}
}
