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
import com.everis.alicante.training.spring.mvc.services.PersonasService;

@RestController
@RequestMapping("/api/personas")
public class PersonasRestController {

	@Autowired
	private PersonasService personasService;

	@GetMapping
	public ResponseEntity<List<Persona>> getAll() {
		return ResponseEntity.ok(personasService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> get(@PathVariable String id){
		final Persona resultado = personasService.get(id);
		if(resultado==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(resultado);
	}

	@PostMapping
	public ResponseEntity<List<Persona>> add(@RequestBody Persona persona) {
		return ResponseEntity.ok(personasService.add(persona));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<List<Persona>> remove(@PathVariable String id){
		
		if(listaPersonas.stream().filter(p-> p.getId().equals(id)).findAny().orElse(null)==null) {
			return ResponseEntity.badRequest().header("error", "No existe la persona").build();
		}
		listaPersonas.removeIf(p -> p.getId().equals(id));
		return ResponseEntity.ok(listaPersonas);
	}
	
	/*@PutMapping("/{id}")
	public Persona update(@PathVariable String id, @RequestBody Persona persona) {
		if(!id.equals(persona.getId())) {
			throw new IllegalArgumentException("Los ids no coinciden");
		}
		return listaPersonas.stream().filter(p-> p.getId().equals(id)).peek(p-> {
			p.setNombre(persona.getNombre());
			p.setEdad(persona.getEdad());
		}).findAny().orElse(null);
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> update(@PathVariable String id, @RequestBody Persona persona) {
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
