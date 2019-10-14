package com.everis.alicante.training.spring.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return (Persona) listaPersonas.stream().filter(p-> p.getId().equals(id)).findAny().orElse(null);
	}

	@PostMapping
	public List<Persona> guardar(@RequestBody Persona persona) {
		listaPersonas.add(persona);
		return listaPersonas;
	}

	@DeleteMapping("/{id}")
	public List<Persona> delete(@PathVariable String id){
		listaPersonas.removeIf(p -> p.getId().equals(id));
		return listaPersonas;
	}
	
	/*@PutMapping("/{id}")
	public Persona modificar(@PathVariable String id, @RequestBody Persona persona) {
		if(!id.equals(persona.getId())) {
			throw new IllegalArgumentException("Los ids no coinciden");
		}
		return listaPersonas.stream().filter(p-> p.getId().equals(id)).peek(p-> {
			p.setNombre(persona.getNombre());
			p.setEdad(persona.getEdad());
		}).findAny().orElse(null);
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> modificar(@PathVariable String id, @RequestBody Persona persona) {
		if(!id.equals(persona.getId())) {
			return ResponseEntity.badRequest().header("error","Los ids no coinciden").build();
		}
		final Persona resultado = listaPersonas.stream().filter(p-> p.getId().equals(id)).peek(p-> {
			p.setNombre(persona.getNombre());
			p.setEdad(persona.getEdad());
		}).findAny().orElse(null);
		
		return ResponseEntity.ok(resultado);
	}
	
}
