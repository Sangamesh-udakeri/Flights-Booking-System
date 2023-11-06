package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Airplane;
import com.project.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	List<Seat> findByAirplane(Airplane airplane);

}
