package com.meli.test.service;

import java.util.List;

import com.meli.test.domain.PositionDTO;
import com.meli.test.domain.SatelliteDTO;
import com.meli.test.exceptions.ResponseException;

public interface CommandCenterService {

	PositionDTO getLocation(List<SatelliteDTO> satellites) throws ResponseException;
	
	PositionDTO getLocation(List<SatelliteDTO> satellites, String nameSatellite) throws ResponseException;

	String getMessage(List<SatelliteDTO> satellite) throws ResponseException;

}
