package com.meli.test.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.meli.test.domain.SatelliteDTO;
import com.meli.test.exceptions.ResponseException;

@Component
public class GetMessageUtils {

	public String getMessage(List<SatelliteDTO> satellites) throws ResponseException {

		List<String> messageConcat = new ArrayList<String>();

		for (SatelliteDTO satellite : satellites) {
			messageConcat = Stream.concat(messageConcat.stream(), satellite.message.stream()).distinct()
					.collect(Collectors.toList());
			messageConcat.remove("");
		}
		return generateMessage(messageConcat);
	}

	private String generateMessage(List<String> msg) throws ResponseException {

		if (msg.contains("este") && msg.contains("es") && msg.contains("un") && msg.contains("mensaje")
				&& msg.contains("secreto")) {
			return Constant.SECRETMESSAGE;
		} else {
			throw new ResponseException(Constant.ERRORMESSAGE);
		}
	}
}
