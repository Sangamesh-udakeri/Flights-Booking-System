package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
