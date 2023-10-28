package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Airplane;
import com.project.service.AirplaneService;

@RequestMapping("/admin")
@RestController
public class AirplaneController {

	@Autowired
	AirplaneService airplaneService;

	@GetMapping("/getAllAirplane")
	public ResponseEntity<List<Airplane>> getAirplanes() {
		List<Airplane> airplanes = airplaneService.getAirplanes();
		return new ResponseEntity<List<Airplane>>(airplanes, HttpStatus.OK);
	}

	@GetMapping("getAirplane/{id}")
	public ResponseEntity<Airplane> getAirplane(@PathVariable Long id) {
		Airplane airplanes = airplaneService.getAirplane(id);
		return new ResponseEntity<Airplane>(airplanes, HttpStatus.OK);
	}

	@PostMapping("createAirplane")
	public ResponseEntity<String> createAirplane(@RequestBody Airplane airplane) {
		String createAirplane = airplaneService.createAirplane(airplane);
		return new ResponseEntity<String>(createAirplane, HttpStatus.OK);
	}

	@DeleteMapping("deleteAirplane/{id}")
	public ResponseEntity<String> deleteAirplane(@PathVariable Long id) {
		String deleteAirplane = airplaneService.deleteAirplane(id);
		return new ResponseEntity<String>(deleteAirplane, HttpStatus.OK);
	}
	
	@PostMapping("/updateAirplane")
	public ResponseEntity<String> updateAirplane( @RequestBody Airplane id) {
		String deleteAirplane = airplaneService.updateAirplane(id);
		return new ResponseEntity<String>(deleteAirplane, HttpStatus.OK);
	}

}
