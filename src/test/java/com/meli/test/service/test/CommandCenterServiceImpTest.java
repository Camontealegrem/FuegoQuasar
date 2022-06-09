package com.meli.test.service.test;

import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.meli.test.domain.SatelliteDTO;
import com.meli.test.exceptions.ResponseException;
import com.meli.test.service.imp.CommandCenterServiceImp;
import com.meli.test.utils.Constant;
import com.meli.test.utils.GetMessageUtils;
import com.meli.test.utils.GetPositionsUtils;

@RunWith(MockitoJUnitRunner.class)
public class CommandCenterServiceImpTest {

  @InjectMocks CommandCenterServiceImp commandCenterServiceImp;

  @Mock GetMessageUtils getMessageUtils;
  @Mock GetPositionsUtils getPositionsUtils;

  @Test
  public void getLocationTest() throws ResponseException {
    assertNull(commandCenterServiceImp.getLocation(buildListSatellite()));
  }

  @Test
  public void getLocationOtherTest() throws ResponseException {
    assertNull(commandCenterServiceImp.getLocation(buildListSatellite(), "sato"));
  }

  @Test
  public void getMessageTest() throws ResponseException {
    assertNull(commandCenterServiceImp.getMessage(buildListSatellite()));
  }

  @Test(expected = ResponseException.class)
  public void getLocationTestException() throws ResponseException {
    assertNull(commandCenterServiceImp.getLocation(buildListSatelliteException()));
  }

  @Test(expected = ResponseException.class)
  public void getLocationTestExceptionName() throws ResponseException {
    assertNull(commandCenterServiceImp.getLocation(buildListSatelliteExceptionName()));
  }

  private List<SatelliteDTO> buildListSatellite() {
    List<SatelliteDTO> satellites = new ArrayList<>();
    List<String> message = new ArrayList<>();
    message.add("este");

    satellites.add(
        SatelliteDTO.builder().name(Constant.SATO).distance(100).message(message).build());
    satellites.add(
        SatelliteDTO.builder().name(Constant.KENOBI).distance(100).message(message).build());
    satellites.add(
        SatelliteDTO.builder().name(Constant.SKYWALKER).distance(100).message(message).build());
    return satellites;
  }

  private List<SatelliteDTO> buildListSatelliteException() {
    List<SatelliteDTO> satellites = new ArrayList<>();
    List<String> message = new ArrayList<>();
    message.add("este");
    satellites.add(
        SatelliteDTO.builder().name(Constant.SATO).distance(100).message(message).build());
    return satellites;
  }

  private List<SatelliteDTO> buildListSatelliteExceptionName() {
    List<SatelliteDTO> satellites = new ArrayList<>();
    List<String> message = new ArrayList<>();
    message.add("este");
    satellites.add(SatelliteDTO.builder().name(null).distance(100).message(message).build());
    satellites.add(SatelliteDTO.builder().name("").distance(100).message(message).build());
    satellites.add(SatelliteDTO.builder().name("").distance(100).message(message).build());
    return satellites;
  }
}
