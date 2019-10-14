package com.everis.alicante.training.spring.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.everis.alicante.training.spring.mvc.domain.Persona;

@Service
public class PersonasService {
	
	@Autowired
	private List<Persona> listaPersonas;
	
	public List<Persona> getAll(){
		return listaPersonas;
	}
	
	public Persona get(String id){
		return listaPersonas.stream().filter(p-> p.getId().equals(id)).findAny().orElse(null);
	}
	
	public List<Persona> add(Persona persona) {
		listaPersonas.add(persona);
		return listaPersonas;
	}

	public List<Persona> remove(String id){
		if(listaPersonas.stream().filter(p-> p.getId().equals(id)).findAny().orElse(null)==null) {
			return null;
		}
		listaPersonas.removeIf(p -> p.getId().equals(id));
		return listaPersonas;
	}
}
