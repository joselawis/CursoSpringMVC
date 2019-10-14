package com.everis.alicante.training.spring.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.everis.alicante.training.spring.mvc.domain.Persona;

@Repository
@Profile("!test")
public class PersonasRepositoryImpl implements PersonasRepository {
	
	private List<Persona> listaPersonas;
	
	public PersonasRepositoryImpl(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	@Override
	public List<Persona> getAll() {
		return listaPersonas;
	}
	
	@Override
	public Persona getById(String id) {
		return listaPersonas.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
	}
	
	@Override
	public void add(Persona p) {
		listaPersonas.add(p);
	}
	
	@Override
	public void remove(String id) {
		listaPersonas.removeIf(p -> p.getId().equals(id));
	}
	
	@Override
	public Persona modificar(String id, Persona persona) {
		return listaPersonas.stream().filter(p -> p.getId().equals(id)).peek(p -> {
			p.setNombre(persona.getNombre());
			p.setEdad(persona.getEdad());
		}).findAny().orElse(null);
	}
}
