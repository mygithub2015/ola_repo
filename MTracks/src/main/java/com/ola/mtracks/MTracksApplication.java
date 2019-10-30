package com.ola.mtracks;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class MTracksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MTracksApplication.class, args);
	
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
