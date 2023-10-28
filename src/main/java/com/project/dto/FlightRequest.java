package com.project.dto;

import java.sql.Timestamp;
import java.time.LocalTime;

import com.project.model.Airplane;
import com.project.model.Airport;

import lombok.Data;

@Data
public class FlightRequest {

	private Long airplaneId;
	private Integer departureAirport;
	private String flightNumber;
	private LocalTime departureTime;
	private Integer arrivalAirport;
	private LocalTime arrivalTime;
	private String boardingGate;
	private Integer totalSeats;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
