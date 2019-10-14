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
	public ResponseEntity<List<Persona>> lista() {
		return ResponseEntity.ok(personasService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> persona(@PathVariable String id) {
		final Persona persona = personasService.getById(id);
		if(persona == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(persona);
	}

	
	
	@PostMapping
	public ResponseEntity<List<Persona>> guardar(@RequestBody Persona persona) {
		personasService.add(persona);
		return ResponseEntity.ok(personasService.getAll());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Persona>> eliminar(@PathVariable String id) {
		personasService.remove(id);
		return ResponseEntity.ok(personasService.getAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> modificar(@PathVariable String id, @RequestBody Persona persona) {
		if( !id.equals(persona.getId())) {
			return ResponseEntity.badRequest().header("error", "Los ids no coinciden").build();
		}
		return ResponseEntity.ok(personasService.modificar(id, persona));
	}
}
