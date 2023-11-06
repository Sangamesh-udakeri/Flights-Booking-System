package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.SeatBook;
import com.project.model.Airplane;
import com.project.model.Seat;
import com.project.repository.AirplaneRepostitory;
import com.project.repository.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatRepository seatRepository;
	@Autowired
	AirplaneRepostitory airplaneRepostitory;
	
	@Override
	public Seat createSeat(SeatBook seat) {
		Seat seat2=new Seat();
		seat2.setSeatColumn(seat.getSeatColumn());
		seat2.setSeatRow(seat.getSeatRow());
		seat2.setSeatType(seat.getSeatType());
		seat2.setAirplane(airplaneRepostitory.findById(seat.getAirplaneId()).get());
		return seatRepository.save(seat2);
	}

	@Override
	public Seat getSeatById(Long id) {
		return seatRepository.findById(id).get();
	}

	@Override
	public List<Seat> getSeats() {
		return seatRepository.findAll();
	}

	@Override
	public List<Seat> getAllSeatsForAirplane(Airplane airplane) {
		return seatRepository.findByAirplane(airplane);
	}

	
}
