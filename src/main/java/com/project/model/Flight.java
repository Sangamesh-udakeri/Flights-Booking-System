package com.project.model;

import java.sql.Timestamp;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "FLIGHT")
public class Flight {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String flightNumber;

	    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "airplane_id")
	    private Airplane airplane;

	    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "departure_airport_id")
	    private Airport departureAirport;

	    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "arrival_airport_id")
	    private Airport arrivalAirport;

	    private LocalTime departureTime;
	    private LocalTime arrivalTime;
	    private String boardingGate;
	    private Integer totalSeats;
	    private Timestamp createdAt;
	    private Timestamp updatedAt;
}
