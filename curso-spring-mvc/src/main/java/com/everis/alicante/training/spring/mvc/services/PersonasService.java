package com.everis.alicante.training.spring.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.training.spring.mvc.domain.Persona;

@Service
public class PersonasService {
	@Autowired
	private List<Persona> listaPersonas;
	
	public List<Persona> getAll() {
		return listaPersonas;
	}
	
	public Persona getById(String id) {
		return listaPersonas.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
	}
	
	public void add(Persona p) {
		listaPersonas.add(p);
	}
	
	public void remove(String id) {
		listaPersonas.removeIf(p -> p.getId().equals(id));
	}
	
	public Persona modificar(String id, Persona persona) {
		return listaPersonas.stream().filter(p -> p.getId().equals(id)).peek(p -> {
			p.setNombre(persona.getNombre());
			p.setEdad(persona.getEdad());
		}).findAny().orElse(null);
	}
}
