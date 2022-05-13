package com.tp.portfolioap.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.portfolioap.model.Persona;
import com.tp.portfolioap.service.Exp_laboralService;
import com.tp.portfolioap.service.PersonaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
	private final PersonaService personaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Persona>>getAllPersona(){
		List<Persona> persona = personaService.findAllPersona();
		return new ResponseEntity<>(persona, HttpStatus.OK);
	}
	@GetMapping("/miperfil")
	public ResponseEntity<Persona> getPerfil(){
		Persona persona = personaService.findPersonaById(1L);
		return new ResponseEntity<>(persona, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Persona>getPersonaById(@PathVariable("id")Long id){
		Persona persona = personaService.findPersonaById(id);
		return new ResponseEntity<>(persona, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Persona> addPersona(@RequestBody Persona persona){
		Persona newPersona = personaService.addPersona(persona);
		return new ResponseEntity<>(newPersona, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePersona(@RequestBody Persona persona){
		Persona updatePersona = personaService.addPersona(persona);
		return new ResponseEntity<>(updatePersona, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePersona(@PathVariable("id")Long id){
		personaService.deletePersona(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
