package com.everis.alicante.training.spring.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.alicante.training.spring.mvc.domain.Persona;

@Controller
@RequestMapping("/personas")
public class PersonasController {
	
	@Autowired
	private List<Persona> listaPersonas;

	@GetMapping
	public String lista(Model model) {
		model.addAttribute("personas", listaPersonas);
		return "personas/lista";
	}
	
	@GetMapping("/nuevo") 
	public String nuevo(Model model) {
		model.addAttribute("persona", new Persona());
		return "personas/nuevo";
	}
	
	@PostMapping("/guardar") 
	public String guardar(@ModelAttribute Persona persona) {
		listaPersonas.add(persona);
		return "redirect:/personas";
	}
}
