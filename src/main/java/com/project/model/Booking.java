package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  bookingId;
	@ManyToOne
	@JoinColumn(name = "flightId")
	private Flight flight;
	private Long    userId;
	@JsonIgnore
	private BookingStatus status;
	private Integer noOfSeats;
	private Double totalCost;
}
