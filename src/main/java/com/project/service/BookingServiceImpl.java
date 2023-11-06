package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.BookingDto;
import com.project.exception.RequiredSeatsNotAvailable;
import com.project.model.Booking;
import com.project.model.Flight;
import com.project.repository.BookingRepository;
import com.project.repository.FlightRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	BookingRepository bookingRepository;
	@Override
	public Booking createBooking(BookingDto booking) {
		Flight flight = flightRepository.findById(booking.getFlightId()).get();
		if(booking.getNoOfSeats()>flight.getTotalSeats()) {
			throw new RequiredSeatsNotAvailable("Seats not availble");
		}
		Booking booking2=new Booking();
		booking2.setUserId(booking.getUserId());
		booking2.setNoOfSeats(booking.getNoOfSeats());
		flight.setTotalSeats(flight.getTotalSeats()-booking.getNoOfSeats());
		booking2.setTotalCost(2000.00*booking.getNoOfSeats());
		booking2.setFlight(flightRepository.findById(booking.getFlightId()).get());
		flightRepository.save(flight);
		return bookingRepository.save(booking2);
	}

}
