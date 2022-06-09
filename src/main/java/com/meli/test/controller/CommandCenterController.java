package com.meli.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.meli.test.domain.SatelliteRequestDTO;

import com.meli.test.exceptions.ResponseException;
import com.meli.test.usecase.CommandCenterProcessor;
import com.meli.test.utils.Constant;

@RestController
@CrossOrigin(
  origins = "*",
  methods = {RequestMethod.GET, RequestMethod.POST}
)
@RequestMapping("/rebelAlliance")
public class CommandCenterController {

  @Autowired CommandCenterProcessor commandCenterProcessor;

  @PostMapping("/topsecret")
  public ResponseEntity<Object> getLocationAndMessage(
      @RequestBody final SatelliteRequestDTO listSatellite) {

    Map<String, Object> response = new HashMap<>();

    try {
      response.put(
          Constant.RESPONSECODE, commandCenterProcessor.getLocationAndMessage(listSatellite));
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (ResponseException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @PostMapping("/topsecret_split")
  public ResponseEntity<Object> splitMessageSecret(
      @RequestParam final String satellite_name,
      @RequestBody final SatelliteRequestDTO listSatellite) {

    Map<String, Object> response = new HashMap<>();

    try {
      response.put(
          Constant.RESPONSECODE,
          commandCenterProcessor.getLocationAndMessageOneSatellite(listSatellite, satellite_name));
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (ResponseException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }
}
