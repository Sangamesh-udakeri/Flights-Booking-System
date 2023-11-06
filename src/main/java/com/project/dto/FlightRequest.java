package com.project.dto;

import java.sql.Timestamp;
import java.time.LocalTime;

import com.project.model.Airplane;
import com.project.model.Airport;

import lombok.Data;

@Data
public class FlightRequest {

	private Long airplaneId;
	private Long departureAirport;
	private String flightNumber;
	private LocalTime departureTime;
	private Long arrivalAirport;
	private LocalTime arrivalTime;
	private Double price;
	private String boardingGate;
	private Integer totalSeats;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
