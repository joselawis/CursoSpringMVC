package com.everis.alicante.training.spring.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.training.spring.mvc.domain.Persona;

@RestController
@RequestMapping("/api/personas")
public class PersonasRestController {

	@Autowired
	private List<Persona> listaPersonas;

	@GetMapping
	public List<Persona> lista() {
		return listaPersonas;
	}
	
	@GetMapping("/{id}")
	public Persona getById(@PathVariable String id){
		return (Persona) listaPersonas.stream().filter(persona-> persona.getId().equals(id)).findAny().orElse(null);
	}

	@PostMapping
	public List<Persona> guardar(@RequestBody Persona persona) {
		listaPersonas.add(persona);
		return listaPersonas;
	}

}
