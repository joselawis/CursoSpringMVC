package com.everis.alicante.training.spring.mvc.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/foo")
public class FooController {

	@RequestMapping()
	public String foo() {
		return "foo";
	}
	
	/*@RequestMapping("/bar")
	public ModelAndView bar() {
		final ModelAndView mav = new ModelAndView("foo");
		mav.addObject("bar", "texto en el modelo ${bar}");
		return mav;
	}*/
	
	/*@RequestMapping("/bar")
	public String bar(@RequestParam(required=false) String name, Model model) {
		final Optional<String> nameOpt = Optional.ofNullable(name);
		model.addAttribute("bar", nameOpt.orElse("VACIDO") + " mediante RequestParam");
		return "foo";
	}*/
	
	@RequestMapping("/bar")
	public String bar(@RequestParam(required=false, defaultValue="VACIDO") String name, Model model) {
		model.addAttribute("bar", name + " mediante RequestParam");
		return "foo";
	}
	
	@GetMapping("/bar/{name}")
	public String barPath(@PathVariable String name, Model model) {
		model.addAttribute("bar", name + " mediante Path");
		return "foo";
	}
}
