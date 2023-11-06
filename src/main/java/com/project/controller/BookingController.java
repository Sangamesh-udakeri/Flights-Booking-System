package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.BookingDto;
import com.project.model.Booking;
import com.project.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/createBooking")
	public ResponseEntity<Booking> createBooking(BookingDto booking){
		Booking createBooking = bookingService.createBooking(booking);
		return new ResponseEntity<Booking>(createBooking,HttpStatus.CREATED);
	}
}
