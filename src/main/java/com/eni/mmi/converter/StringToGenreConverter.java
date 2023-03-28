package com.eni.mmi.converter;

import com.eni.bo.Genre;
import com.eni.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {
	// Injection des services
	private MovieService service;

	@Autowired
	public StringToGenreConverter(MovieService service) {
		this.service = service;
	}

	@Override
	public Genre convert(String id) {
		Long theId = Long.parseLong(id);
		return service.getGenreById(theId);
	}
}
