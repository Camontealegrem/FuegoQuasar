package com.meli.test.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meli.test.domain.ResponseDTO;
import com.meli.test.domain.SatelliteRequestDTO;
import com.meli.test.exceptions.ResponseException;
import com.meli.test.service.CommandCenterService;


/** @author camontealegre */
@Component
public class CommandCenterProcessor {

  @Autowired CommandCenterService commandCenterService;

  public ResponseDTO getLocationAndMessage(SatelliteRequestDTO satellites)
      throws ResponseException {
    try {
      return ResponseDTO.builder()
          .position(commandCenterService.getLocation(satellites.satellites))
          .message(commandCenterService.getMessage(satellites.satellites))
          .build();

    } catch (ResponseException e) {
      throw new ResponseException(e.getMessage());
    }
  }
  
  public ResponseDTO getLocationAndMessageOneSatellite(SatelliteRequestDTO satellites , String satelliteName)
	      throws ResponseException {
	    try {   	    
	    	
	      return ResponseDTO.builder()
	          .position(commandCenterService.getLocation(satellites.satellites, satelliteName ))
	          .message(commandCenterService.getMessage(satellites.satellites))
	          .build();

	    } catch (ResponseException e) {
	      throw new ResponseException(e.getMessage());
	    }
	  }
}
