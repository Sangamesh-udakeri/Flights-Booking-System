package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.SeatBook;
import com.project.model.Airplane;
import com.project.model.Seat;
import com.project.service.SeatService;

@RestController
public class SeatController {

	@Autowired
	SeatService seatService;
	
	@PostMapping("/createseat")
	public ResponseEntity<Seat> createSeat(SeatBook seat){
		Seat createSeat = seatService.createSeat(seat);
		return new ResponseEntity<Seat>(createSeat,HttpStatus.CREATED);
	}
	@GetMapping("/getseat")
	public ResponseEntity<Seat> geteSeat(Long id){
		Seat seat = seatService.getSeatById(id);
		return new ResponseEntity<Seat>(seat,HttpStatus.CREATED);
	}
	@GetMapping("/getseats")
	public ResponseEntity<List<Seat>> geteSeats(){
		 List<Seat> seats = seatService.getSeats();
		return new ResponseEntity<List<Seat>>(seats,HttpStatus.CREATED);
	}
	@GetMapping("/getAllSeatsForAirplane")
	public ResponseEntity<List<Seat>> geteAllSeatsForAirplane(Airplane airplane){
		List<Seat> allSeatsForAirplane = seatService.getAllSeatsForAirplane(airplane);
		return new ResponseEntity<List<Seat>>(allSeatsForAirplane,HttpStatus.CREATED);
	}
}
