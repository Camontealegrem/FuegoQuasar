package com.meli.test.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class SatelliteDTO {

	@JsonProperty("name")
	public String name;

	@JsonProperty("distance")
	public double distance;

	@JsonProperty("message")
	public List<String> message;

}
