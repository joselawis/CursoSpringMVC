package com.everis.alicante.training.spring.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.everis.alicante.training.spring.mvc.domain.Persona;

@SpringBootApplication
public class CursoSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringMvcApplication.class, args);
	}

	@Bean
	public List<Persona> listaPersonas() {
		return new ArrayList<>(Arrays.asList(new Persona("1", "Persona 1", 20), 
											new Persona("2", "Persona 2", 24)));
	}

}
