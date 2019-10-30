package com.ola.mtracks.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ola.mtracks.enums.Gender;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {

	@Override
	public String convertToDatabaseColumn(Gender gender) {
		if(gender == null) return null;
		return gender.getGender();
	}

	@Override
	public Gender convertToEntityAttribute(String code) {
		// TODO Auto-generated method stub
		if(code == null) return null;
		
		System.out.println("Gender converter=>code: "+code);
		
		return Stream.of(Gender.values()).filter(s->s.getGender().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
