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
import com.tp.portfolioap.model.Edu_formal;
import com.tp.portfolioap.model.Persona;
import com.tp.portfolioap.service.CursoService;
import com.tp.portfolioap.service.Edu_formalService;
import com.tp.portfolioap.service.Exp_laboralService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/eduformal")
@RequiredArgsConstructor
public class Edu_formalController {

	private final Edu_formalService edu_formalService;
	private final Long IDPERSONA=1L; 
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Edu_formal> getEdu_formalById(@PathVariable("id") Long id) {
		Edu_formal edu_formal = edu_formalService.findEdu_formalById(id);
		return new ResponseEntity<>(edu_formal, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Edu_formal> addEdu_formal(@RequestBody Edu_formal edu_formal) {
		Persona p = new Persona();
		p.setIdPersona(IDPERSONA);
		edu_formal.setPersona(p);
		Edu_formal eduformal = edu_formalService.addEdu_formal(edu_formal);
		return new ResponseEntity<>(eduformal, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateEdu_formal(@RequestBody Edu_formal edu_formal) {
		Edu_formal nuevaedu = edu_formalService.findEdu_formalById(edu_formal.getIdEduformal()); 
		if (nuevaedu==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		Persona p = new Persona();
		p.setIdPersona(IDPERSONA);
		edu_formal.setPersona(p);
		
		Edu_formal updateEduformal = edu_formalService.addEdu_formal(edu_formal);
		return new ResponseEntity<>(updateEduformal, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEdu_formal(@PathVariable("id") Long id) {
		edu_formalService.deleteEdu_formal(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
