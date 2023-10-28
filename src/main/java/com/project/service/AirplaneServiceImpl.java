package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.AirplaneNotFoundException;
import com.project.model.Airplane;
import com.project.repository.AirplaneRepostitory;

@Service
public class AirplaneServiceImpl implements AirplaneService {

	@Autowired
	AirplaneRepostitory airplaneRepostitory;

	@Override
	public List<Airplane> getAirplanes() {
		List<Airplane> findAll = airplaneRepostitory.findAll();
		return findAll;
	}

	@Override
	public Airplane getAirplane(Long id) {
		Optional<Airplane> findById = airplaneRepostitory.findById(id);
		if (!findById.isPresent()) {

			throw new AirplaneNotFoundException("Could not Find Airplane by id");
		}
		return findById.get();

	}

	@Override
	public String deleteAirplane(Long id) {
		Optional<Airplane> findById = airplaneRepostitory.findById(id);
		if (!findById.isPresent()) {

			throw new AirplaneNotFoundException("Could not Find Airplane by id");
		}
		airplaneRepostitory.deleteById(id);
		return "deleted";
	}

	@Override
	public String updateAirplane(Airplane airplane) {
		airplaneRepostitory.save(airplane);
		return "updated";
	}

	@Override
	public String createAirplane(Airplane airplane) {
		airplaneRepostitory.save(airplane);
		return "saved";
	}

}
