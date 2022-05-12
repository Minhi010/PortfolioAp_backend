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
import com.tp.portfolioap.service.CursoService;
import com.tp.portfolioap.service.HabilidadService;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {
	private final HabilidadService habilidadService;

	public HabilidadController(HabilidadService habilidadService) {
		this.habilidadService=habilidadService;
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Habilidad> getHabilidadById(@PathVariable("id") Long id) {
		Habilidad habilidades =habilidadService.findHabilidadById(id);
		return new ResponseEntity<>(habilidades, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Habilidad> addHabilidad(@RequestBody Habilidad habilidad) {
		Habilidad habilidades = habilidadService.addHabilidad(habilidad);
		return new ResponseEntity<>(habilidades, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Habilidad> updateHabilidad(@RequestBody Habilidad habilidad) {
		Habilidad updateHabilidad = habilidadService.addHabilidad(habilidad);
		return new ResponseEntity<>(updateHabilidad, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteHabilidad(@PathVariable("id") Long id) {
		habilidadService.deleteHabilidad(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
