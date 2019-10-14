package com.everis.alicante.training.spring.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.training.spring.mvc.domain.Persona;

@Service
public class PersonasServiceImpl implements PersonasService {
	
	private PersonasRepository personasRepository;
	
	public PersonasServiceImpl(PersonasRepository personasRepository) {
		this.personasRepository = personasRepository;
	}

	@Override
	public List<Persona> getAll() {
		return personasRepository.getAll();
	}
	
	@Override
	public Persona getById(String id) {
		return personasRepository.getById(id);
	}
	
	@Override
	public void add(Persona p) {
		personasRepository.add(p);
	}
	
	@Override
	public void remove(String id) {
		personasRepository.remove(id);
	}
	
	@Override
	public Persona modificar(String id, Persona persona) {
		return personasRepository.modificar(id, persona);
	}
}
