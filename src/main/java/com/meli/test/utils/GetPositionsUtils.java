package com.meli.test.utils;

import java.util.List;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Component;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.meli.test.domain.PositionDTO;
import com.meli.test.domain.SatelliteDTO;
import com.meli.test.exceptions.ResponseException;

@Component
public class GetPositionsUtils {

  public PositionDTO calculatedPosition(List<SatelliteDTO> satellites) {  	  

    NonLinearLeastSquaresSolver positionShip =
        new NonLinearLeastSquaresSolver(
            new TrilaterationFunction(
                LocationSatellites.TOTALLOCATIONSATELLITES, getDistances(satellites)),
            new LevenbergMarquardtOptimizer());

    return PositionDTO.builder()
        .x(positionShip.solve().getPoint().toArray()[0])
        .y(positionShip.solve().getPoint().toArray()[1])
        .build();
  }
  
  public PositionDTO calculatedPosition(List<SatelliteDTO> satellites, String satelliteName) throws ResponseException {  	
	  
	  double [][] locationSatellite;
	  try {
	  switch (satelliteName) {
		case Constant.SATO:			
			locationSatellite = LocationSatellites.SATOLOCATION;			
			break;
			
		case Constant.KENOBI:			
			locationSatellite = LocationSatellites.KENOBILOCATION;			
			break;
			
		case Constant.SKYWALKER:			
			locationSatellite = LocationSatellites.SKYWALKERLOCATION;			
			break;	
			
		default:
			throw new ResponseException(Constant.ERRORDISTANCE);
		}

	    NonLinearLeastSquaresSolver positionShip =
	        new NonLinearLeastSquaresSolver(
	            new TrilaterationFunction(locationSatellite, getDistances(satellites)),
	            new LevenbergMarquardtOptimizer());

	    return PositionDTO.builder()
	        .x(positionShip.solve().getPoint().toArray()[0])
	        .y(positionShip.solve().getPoint().toArray()[1])
	        .build();
	  } catch(Exception e){
		  throw new ResponseException(Constant.ERRORNAME);
		  
	  }
	  }

  private double[] getDistances(List<SatelliteDTO> satellites) {
    double[] distances = new double[satellites.size()];
    for (int i = 0; i < satellites.size(); i++) {
      distances[i] = satellites.get(i).distance;
    }
    return distances;
  }
}
