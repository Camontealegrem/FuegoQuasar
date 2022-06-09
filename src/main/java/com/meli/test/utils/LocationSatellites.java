package com.meli.test.utils;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class LocationSatellites {

	public static final double[][] TOTALLOCATIONSATELLITES = new double[][] { { -500, -200 }, { 100, -100 }, { 500, 100 } };
	public static final double[][] SATOLOCATION = new double[][] { { 500, 100 }, { 100, -100 }};
	public static final double[][] SKYWALKERLOCATION = new double[][] { { 100, -100 }, { -500, -200 } };
	public static final double[][] KENOBILOCATION = new double[][] { { -500, -200 } , { 100, -100}};

}