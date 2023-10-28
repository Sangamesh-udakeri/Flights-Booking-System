package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.CityNotFoundException;
import com.project.model.City;
import com.project.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository cityRepository;
	@Override
	public List<City> getCities() {
		List<City> findAll = cityRepository.findAll();
		return findAll;
	}

	@Override
	public City getCity(Long id) throws CityNotFoundException {
		Optional<City> findById = cityRepository.findById(id);
		if(!findById.isPresent()) {
			throw new CityNotFoundException("Could not find city With the id");
		}
		return findById.get();
	}

	@Override
	public String createCity(City city) {
		cityRepository.save(city);
		return "saved";
	}

	@Override
	public String deleteCity(Long id) throws CityNotFoundException {
		Optional<City> findById = cityRepository.findById(id);
		if(!findById.isPresent()) {
			throw new CityNotFoundException("Could not find city With the id");
		}
		cityRepository.deleteById(id);
		
		return "deleted";
	}
	

	@Override
	public String updateCity(City city) {
		cityRepository.save(city);
		return "updated";
	}

}
