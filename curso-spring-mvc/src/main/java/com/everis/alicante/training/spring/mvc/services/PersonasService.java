package com.everis.alicante.training.spring.mvc.services;

import java.util.List;

import com.everis.alicante.training.spring.mvc.domain.Persona;

public interface PersonasService {

	List<Persona> getAll();

	Persona getById(String id);

	void add(Persona p);

	void remove(String id);

	Persona modificar(String id, Persona persona);

}