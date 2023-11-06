package com.project.service;

import java.util.List;

import com.project.dto.SeatBook;
import com.project.model.Airplane;
import com.project.model.Seat;

public interface SeatService {

	public Seat createSeat(SeatBook seat);
	public Seat getSeatById(Long id);
	public List<Seat> getSeats();
	public List<Seat> getAllSeatsForAirplane(Airplane airplane);
	      
}
