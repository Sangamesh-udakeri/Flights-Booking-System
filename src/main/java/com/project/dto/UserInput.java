package com.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;


import com.project.model.Flight;

import lombok.Data;

@Data
public class UserInput {

	private Long arrivalAirportId;
	private Long departureAirportId;
	private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Double maxPrice;
    private Double minPrice;
}
