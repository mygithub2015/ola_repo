package com.ola.mtracks.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ola.mtracks.enums.Genre;
@Converter(autoApply = true)
public class GenreConverter implements AttributeConverter<Genre, String> {
	{

	}

	@Override
	public String convertToDatabaseColumn(Genre genre) {
		if(genre == null) return null;
		return genre.getGenre();
	}

	@Override
	public Genre convertToEntityAttribute(String code) {
		if(code== null)
			return null;
		return Stream.of(Genre.values()).filter(s -> s.getGenre().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);

	}

}
