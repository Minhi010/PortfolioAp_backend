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
import com.tp.portfolioap.model.Persona;
import com.tp.portfolioap.service.CursoService;
import com.tp.portfolioap.service.Exp_laboralService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {
	private final CursoService cursoService;
	private final Long IDPERSONA=1L; 
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Curso> getCursoById(@PathVariable("id")Long id){
		Curso curso = cursoService.findCursoById(id);
		return new ResponseEntity<>(curso, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Curso> addCurso(@RequestBody Curso curso){
		Persona p = new Persona();
		p.setIdPersona(IDPERSONA);
		curso.setPersona(p);
		Curso cursos = cursoService.addCurso(curso);
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateCurso(@RequestBody Curso curso){
		Curso nuevocurso = cursoService.findCursoById(curso.getIdCurso()); 
		if (nuevocurso==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		Persona p = new Persona();
		p.setIdPersona(IDPERSONA);
		curso.setPersona(p);
		
		Curso updateCurso = cursoService.addCurso(curso);
		return new ResponseEntity<>(updateCurso, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCurso(@PathVariable("id")Long id){
		cursoService.deleteCurso(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
