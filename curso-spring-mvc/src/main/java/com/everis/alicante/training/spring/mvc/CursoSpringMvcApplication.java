package com.everis.alicante.training.spring.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.everis.alicante.training.spring.mvc.domain.Persona;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CursoSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringMvcApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.everis.alicante.training.spring.mvc"))
				.paths(PathSelectors.ant("/api/**")).build();
	}

	@Bean
	public List<Persona> listaPersonas() {
		return new ArrayList<>(Arrays.asList(new Persona("1", "Persona 1", 20), new Persona("2", "Persona 2", 25)));
	}
}
