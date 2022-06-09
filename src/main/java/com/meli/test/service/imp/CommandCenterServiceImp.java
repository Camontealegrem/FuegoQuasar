package com.meli.test.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.test.domain.PositionDTO;
import com.meli.test.domain.SatelliteDTO;
import com.meli.test.exceptions.ResponseException;
import com.meli.test.service.CommandCenterService;
import com.meli.test.utils.Constant;
import com.meli.test.utils.GetMessageUtils;
import com.meli.test.utils.GetPositionsUtils;

@Service
public class CommandCenterServiceImp implements CommandCenterService {

  @Autowired GetMessageUtils getMessageUtils;
  @Autowired GetPositionsUtils getPositionsUtils;

  @Override
  public PositionDTO getLocation(List<SatelliteDTO> satellites) throws ResponseException {
    validationInfoSatellites(satellites);
    return getPositionsUtils.calculatedPosition(satellites);
  }

  @Override
  public PositionDTO getLocation(List<SatelliteDTO> satellites, String nameSatellite)
      throws ResponseException {
    return getPositionsUtils.calculatedPosition(satellites, nameSatellite);
  }

  @Override
  public String getMessage(List<SatelliteDTO> satellites) throws ResponseException {
    return getMessageUtils.getMessage(satellites);
  }

  public void validationInfoSatellites(List<SatelliteDTO> satellites) throws ResponseException {

    if (satellites.size() < 3) throw new ResponseException(Constant.ERRORPOSITION);

    for (SatelliteDTO satellite : satellites) {
      if (satellite.getName() == null || satellite.getName().equals(""))
        throw new ResponseException(Constant.ERRORNAME);
      if (Double.valueOf(satellite.getDistance()) == 0.0)
        throw new ResponseException(Constant.ERRORDISTANCE);
      if (satellite.getMessage() == null || satellite.getMessage().isEmpty())
        throw new ResponseException(Constant.ERRORMESSAGE);
    }
  }
}
