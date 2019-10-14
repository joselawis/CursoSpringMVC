package com.everis.alicante.training.spring.mvc.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.everis.alicante.training.spring.mvc.domain.Persona;

@RunWith(MockitoJUnitRunner.class)
public class PersonasServiceTest {

	@InjectMocks
	private PersonasServiceImpl personasService;
	
	@Mock
	private PersonasRepository repository;
	
	@Test
	public void test() {
		// Arrange
		List<Persona> personas = null;
		Mockito.when(repository.getAll()).thenReturn(Arrays.asList(new Persona()));
		
		// Act
		personas = personasService.getAll();
		
		// Assert
		Assert.assertNotNull("La lista de personas no puede ser nula", personas);
		Assert.assertEquals("Longitud de la lista no esperada", 1, personas.size());
	}
}
