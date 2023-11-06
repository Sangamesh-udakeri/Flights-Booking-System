package com.project.dto;

import com.project.model.Type;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SeatBook {

	private Long seatId;
	private int seatRow;
	private String seatColumn;
	private Type seatType;
	private Long airplaneId;
}
