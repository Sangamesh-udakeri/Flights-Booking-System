package com.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.model.BookingStatus;
import com.project.model.Flight;

import lombok.Data;

@Data
public class BookingDto {

	private Long flightId;
	private Long    userId;
	private Integer noOfSeats;
	
}
