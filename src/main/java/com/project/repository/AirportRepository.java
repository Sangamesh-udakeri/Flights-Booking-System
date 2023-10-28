package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.model.Airport;
import java.util.List;
import java.util.Optional;


public interface AirportRepository extends JpaRepository<Airport, Integer> {

	List<Airport>  getAirportByCode(String code);
	 @Query("SELECT a\r\n"
		 		+ "FROM Airport a\r\n"
		 		+ "JOIN a.city c\r\n"
		 		+ "WHERE c.name = :cityName")
	List<Airport>  getAirportsByCity(String cityName);
	Optional<Airport> findById(Long id);
}
