package com.project.service;

import java.util.List;

import com.project.exception.CityNotFoundException;
import com.project.model.City;

public interface CityService {

	public List<City> getCities();

	public City getCity(Long id) throws CityNotFoundException;
	
	public String createCity(City city);
	 
	public String deleteCity(Long id) throws CityNotFoundException;
	
	public String updateCity(City city);
}
