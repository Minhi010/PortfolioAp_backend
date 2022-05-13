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
import com.tp.portfolioap.model.Exp_laboral;
import com.tp.portfolioap.model.Persona;
import com.tp.portfolioap.service.CursoService;
import com.tp.portfolioap.service.Exp_laboralService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/explaboral")
@RequiredArgsConstructor
public class Exp_laboralController {
	private final Exp_laboralService exp_laboralService;
	private final Long IDPERSONA=1L; 
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Exp_laboral> getExp_laboralById(@PathVariable("id") Long id) {
		Exp_laboral expLaboral = exp_laboralService.findExp_laboralById(id);
		return new ResponseEntity<>(expLaboral, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Exp_laboral> addCurso(@RequestBody Exp_laboral exp_laboral) {
		Persona p = new Persona();
		p.setIdPersona(IDPERSONA);
		exp_laboral.setPersona(p);
		Exp_laboral expLaboral = exp_laboralService.addExp_laboral(exp_laboral);
		return new ResponseEntity<>(expLaboral, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateExp_laboral(@RequestBody Exp_laboral exp_laboral) {
		Exp_laboral exp = exp_laboralService.findExp_laboralById(exp_laboral.getIdExplaboral());
		if (exp==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Persona p = new Persona();
		p.setIdPersona(IDPERSONA);
		exp_laboral.setPersona(p);
		Exp_laboral updateExp_laboral = exp_laboralService.addExp_laboral(exp_laboral);
		return new ResponseEntity<>(updateExp_laboral, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteExp_laboral(@PathVariable("id") Long id) {
		exp_laboralService.deleteExp_laboral(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
