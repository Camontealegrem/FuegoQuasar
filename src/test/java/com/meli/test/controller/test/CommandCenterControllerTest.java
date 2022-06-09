package com.meli.test.controller.test;

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
import org.springframework.web.server.ResponseStatusException;

import com.meli.test.controller.CommandCenterController;
import com.meli.test.domain.SatelliteDTO;
import com.meli.test.domain.SatelliteRequestDTO;
import com.meli.test.exceptions.ResponseException;
import com.meli.test.usecase.CommandCenterProcessor;
import com.meli.test.utils.Constant;

@RunWith(MockitoJUnitRunner.class)
public class CommandCenterControllerTest {

  @InjectMocks CommandCenterController commandCenterController;

  @Mock CommandCenterProcessor commandCenterProcessor;

  @Test
  public void getLocationAndMessageTest() {
    assertNotNull(commandCenterController.getLocationAndMessage(buildSatelliteRequest()));
  }

  @Test(expected = ResponseStatusException.class)
  public void getLocationAndMessageExceptionTest() throws ResponseException {
    when(commandCenterProcessor.getLocationAndMessage(any())).thenThrow(ResponseException.class);
    assertNotNull(commandCenterController.getLocationAndMessage(buildSatelliteRequest()));
  }

  @Test
  public void splitMessageSecretTest() {
    assertNotNull(commandCenterController.splitMessageSecret("sato", buildSatelliteRequest()));
  }

  @Test(expected = ResponseStatusException.class)
  public void splitMessageSecretExceptionTest() throws ResponseException {
    when(commandCenterProcessor.getLocationAndMessageOneSatellite(any(), anyString()))
        .thenThrow(ResponseException.class);
    assertNotNull(commandCenterController.splitMessageSecret("sato", buildSatelliteRequest()));
  }

  private SatelliteRequestDTO buildSatelliteRequest() {
    List<SatelliteDTO> satellites = new ArrayList<>();
    List<String> message = new ArrayList<>();
    satellites.add(
        SatelliteDTO.builder().name(Constant.SATO).distance(100).message(message).build());
    return SatelliteRequestDTO.builder().satellites(satellites).build();
  }
}
