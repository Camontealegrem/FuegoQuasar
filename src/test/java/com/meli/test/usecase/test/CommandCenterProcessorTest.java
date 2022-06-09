package com.meli.test.usecase.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.meli.test.domain.SatelliteDTO;
import com.meli.test.domain.SatelliteRequestDTO;
import com.meli.test.exceptions.ResponseException;
import com.meli.test.service.CommandCenterService;
import com.meli.test.usecase.CommandCenterProcessor;
import com.meli.test.utils.Constant;

@RunWith(MockitoJUnitRunner.class)
public class CommandCenterProcessorTest {

  @InjectMocks CommandCenterProcessor commandCenterProcessor;

  @Mock CommandCenterService commandCenterService;

  @Test
  public void getLocationAndMessageTest() throws ResponseException {
    assertNotNull(commandCenterProcessor.getLocationAndMessage(buildSatelliteRequest()));
  }

  @Test(expected = ResponseException.class)
  public void getLocationAndMessageExceptionTest() throws ResponseException {
    when(commandCenterService.getLocation(any())).thenThrow(ResponseException.class);
    assertNotNull(commandCenterProcessor.getLocationAndMessage(buildSatelliteRequest()));
  }

  @Test
  public void getLocationAndMessageOneSatelliteTest() throws ResponseException {
    assertNotNull(
        commandCenterProcessor.getLocationAndMessageOneSatellite(buildSatelliteRequest(), "sato"));
  }

  @Test(expected = ResponseException.class)
  public void getLocationAndMessageOneSatelliteExceptionTest() throws ResponseException {
    when(commandCenterService.getLocation(any(), anyString())).thenThrow(ResponseException.class);
    assertNotNull(
        commandCenterProcessor.getLocationAndMessageOneSatellite(buildSatelliteRequest(), "sato"));
  }

  private SatelliteRequestDTO buildSatelliteRequest() {
    List<SatelliteDTO> satellites = new ArrayList<>();
    List<String> message = new ArrayList<>();
    satellites.add(
        SatelliteDTO.builder().name(Constant.SATO).distance(100).message(message).build());
    return SatelliteRequestDTO.builder().satellites(satellites).build();
  }
}
