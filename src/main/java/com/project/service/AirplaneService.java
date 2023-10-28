package com.project.service;

import java.util.List;

import com.project.model.Airplane;

public interface AirplaneService {

	public List<Airplane> getAirplanes();

	public Airplane getAirplane(Long id);

	public String deleteAirplane(Long id);

	public String updateAirplane(Airplane airplane);

	public String createAirplane(Airplane airplane);

}
