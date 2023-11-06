package com.project.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.project.dto.FlightRequest;
import com.project.dto.FlightResponse;
import com.project.dto.SeatBook;
import com.project.dto.SeatData;
import com.project.dto.UserInput;
import com.project.model.Airport;
import com.project.model.City;
import com.project.model.Flight;
import com.project.repository.CityRepository;
import com.project.repository.FlightRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	CityRepository cityRepository;
	@Autowired
	EntityManager entityManager;

	@Override
	public Flight createFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@Override
	public Optional<Flight> getFlightById(Long id) {
		return flightRepository.findById(id);
	}

	public List<FlightResponse> getFlightsByFilter(UserInput userInput) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Flight> cq = cb.createQuery(Flight.class);
		Root<Flight> root = cq.from(Flight.class);

		Predicate predicates = cb.conjunction();

		if (userInput.getDepartureAirportId() != null) {
			predicates = cb.and(predicates,
					cb.equal(root.get("departureAirport").get("id"), userInput.getDepartureAirportId()));
		}

		if (userInput.getArrivalAirportId() != null) {
			predicates = cb.and(predicates,
					cb.equal(root.get("arrivalAirport").get("id"), userInput.getArrivalAirportId()));
		}

		if (userInput.getMinPrice() != null) {
			predicates = cb.and(predicates, cb.greaterThanOrEqualTo(root.get("price"), userInput.getMinPrice()));
		}

		if (userInput.getMaxPrice() != null) {
			predicates = cb.and(predicates, cb.lessThanOrEqualTo(root.get("price"), userInput.getMaxPrice()));
		}

		cq.where(predicates);

		List<Flight> flights = entityManager.createQuery(cq).getResultList();
		List<FlightResponse> flightResponses = new ArrayList<>();

		for (Flight flight : flights) {
			FlightResponse response = mapFlightToResponse(flight);
			flightResponses.add(response);
		}

		return flightResponses;
	}

	private FlightResponse mapFlightToResponse(Flight flight) {
		FlightResponse response = new FlightResponse();
		response.setDepartureAirport(flight.getDepartureAirport());
		response.setArrivalAirport(flight.getArrivalAirport());
		response.setDepartureDate(flight.getDepartureDate());
		response.setArrivalDate(flight.getArrivalDate());
		response.setPrice(flight.getPrice());
		return response;
	}

	public String updateSeats(SeatData seatData) {

		 Flight flight = flightRepository.findById(seatData.getFlightId()).get();
		 if(seatData.getDec()) {
			 flight.setTotalSeats(flight.getTotalSeats()-seatData.getNoOFSeats());
		 }else {
			 flight.setTotalSeats(flight.getTotalSeats()+seatData.getNoOFSeats());
		 }
		 
		 Flight save = flightRepository.save(flight);
		return "updated";
	}

}
