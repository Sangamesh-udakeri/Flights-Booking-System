package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.CityNotFoundException;
import com.project.model.City;
import com.project.service.CityService;


@RestController
@RequestMapping("/admin")
public class CityController {

	@Autowired
	CityService cityService;
	
	@GetMapping("/getCities")
	public ResponseEntity<List<City>> getCities(){
		List<City> cities = cityService.getCities();
		return new ResponseEntity<List<City>>(cities,HttpStatus.OK);
	}

	@GetMapping("/getCity/{id}")
	public ResponseEntity<City> getCity(Long id) throws CityNotFoundException{
		City city = cityService.getCity(id);
		return new ResponseEntity<City>(city,HttpStatus.OK);
	}

	@PostMapping("/createcity")
	public ResponseEntity<String> createCity(@RequestBody City city){
		String createCity = cityService.createCity(city);
		return new ResponseEntity<String>(createCity,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCity(Long id) throws CityNotFoundException{
		String deleteCity = cityService.deleteCity(id);
		return new ResponseEntity<String>(deleteCity,HttpStatus.OK);
	}
	
	@PostMapping("/updatecity")
	public ResponseEntity<String> updateCity(@RequestBody City city){
		String updateCity = cityService.updateCity(city);
		return new ResponseEntity<String>(updateCity,HttpStatus.OK);
	}
}
