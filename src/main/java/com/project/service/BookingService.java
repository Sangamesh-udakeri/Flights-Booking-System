package com.project.service;

import com.project.dto.BookingDto;
import com.project.model.Booking;

public interface BookingService {

	 Booking createBooking(BookingDto booking);
	 
}
