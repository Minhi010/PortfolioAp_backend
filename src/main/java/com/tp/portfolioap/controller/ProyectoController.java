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
import com.tp.portfolioap.model.Proyecto;
import com.tp.portfolioap.service.CursoService;
import com.tp.portfolioap.service.ProyectoService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
	private final ProyectoService proyectoService;

	public ProyectoController(ProyectoService proyectoService) {
		this.proyectoService=proyectoService;
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Proyecto> getProyectoById(@PathVariable("id") Long id) {
		Proyecto proyectos = proyectoService.findProyectoById(id);
		return new ResponseEntity<>(proyectos, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Proyecto> addCurso(@RequestBody Proyecto proyecto) {
		Proyecto proyectos = proyectoService.addProyecto(proyecto);
		return new ResponseEntity<>(proyectos, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Proyecto> updateProyecto(@RequestBody Proyecto proyecto) {
		Proyecto updateProyecto = proyectoService.addProyecto(proyecto);
		return new ResponseEntity<>(updateProyecto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProyecto(@PathVariable("id") Long id) {
		proyectoService.deleteProyecto(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
