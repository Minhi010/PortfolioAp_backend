package com.tp.portfolioap.controller;

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

import com.tp.portfolioap.model.Curso;
import com.tp.portfolioap.model.Habilidad;
import com.tp.portfolioap.model.Persona;
import com.tp.portfolioap.service.CursoService;
import com.tp.portfolioap.service.Exp_laboralService;
import com.tp.portfolioap.service.HabilidadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/habilidades")
@RequiredArgsConstructor
public class HabilidadController {
	private final HabilidadService habilidadService;
	private final Long IDPERSONA=1L; 
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Habilidad> getHabilidadById(@PathVariable("id") Long id) {
		Habilidad habilidades =habilidadService.findHabilidadById(id);
		return new ResponseEntity<>(habilidades, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Habilidad> addHabilidad(@RequestBody Habilidad habilidad) {
		Persona p = new Persona();
		p.setIdPersona(IDPERSONA);
		habilidad.setPersona(p);
		Habilidad habilidades = habilidadService.addHabilidad(habilidad);
		return new ResponseEntity<>(habilidades, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateHabilidad(@RequestBody Habilidad habilidad) {
		Habilidad nuevahabilidad = habilidadService.findHabilidadById(habilidad.getIdHabilidad()); 
		if (nuevahabilidad==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		Persona p = new Persona();
		p.setIdPersona(IDPERSONA);
		habilidad.setPersona(p);
		
		
		Habilidad updateHabilidad = habilidadService.addHabilidad(habilidad);
		return new ResponseEntity<>(updateHabilidad, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteHabilidad(@PathVariable("id") Long id) {
		habilidadService.deleteHabilidad(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
