package com.project.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AirplaneRequest {

	private Long id;
	private String modelNumber;
	private int capacity;
	private LocalDate createdAt; 
	private LocalDate updatedAt; 
	private Long   seatId;
}
