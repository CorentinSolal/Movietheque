package com.eni.mmi.converter;

import com.eni.bo.Participant;
import com.eni.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToParticipantConverter implements Converter<String, Participant> {
	// Injection des services
	private MovieService service;

	@Autowired
	public StringToParticipantConverter(MovieService service) {
		this.service = service;
	}

	@Override
	public Participant convert(String id) {
		Long theId = Long.parseLong(id);
		return service.getParticipantById(theId);
	}
}
