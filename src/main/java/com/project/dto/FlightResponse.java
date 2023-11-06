package com.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.project.model.Airport;
import com.project.model.City;

import lombok.Data;

@Data
public class FlightResponse {

	private City departureAirportCity;
	private City arrivalAirportCity;
	private String departureAirortCode;
	private String arrivalAirortCode;
	private Airport departureAirport;
	private Double price;
	private Airport arrivalAirport;
	private LocalDate departureDate;
    private LocalDate arrivalDate;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	

}
