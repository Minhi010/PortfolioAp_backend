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
import com.tp.portfolioap.model.EduFormal;
import com.tp.portfolioap.model.Persona;
import com.tp.portfolioap.service.CursoService;
import com.tp.portfolioap.service.EduFormalService;
import com.tp.portfolioap.service.ExpLaboralService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/eduformal")
@RequiredArgsConstructor
public class EduFormalController {

	private final EduFormalService edu_formalService;
	private final Long IDPERSONA=1L; 
	
	@GetMapping("/find/{id}")
	public ResponseEntity<EduFormal> getEdu_formalById(@PathVariable("id") Long id) {
		EduFormal edu_formal = edu_formalService.findEdu_formalById(id);
		return new ResponseEntity<>(edu_formal, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<EduFormal> addEdu_formal(@RequestBody EduFormal edu_formal) {
		Persona p = new Persona();
		p.setId(IDPERSONA);
		edu_formal.setPersona(p);
		EduFormal eduformal = edu_formalService.addEdu_formal(edu_formal);
		return new ResponseEntity<>(eduformal, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateEdu_formal(@RequestBody EduFormal edu_formal) {
		EduFormal nuevaedu = edu_formalService.findEdu_formalById(edu_formal.getId()); 
		if (nuevaedu==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		Persona p = new Persona();
		p.setId(IDPERSONA);
		edu_formal.setPersona(p);
		
		EduFormal updateEduformal = edu_formalService.addEdu_formal(edu_formal);
		return new ResponseEntity<>(updateEduformal, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEdu_formal(@PathVariable("id") Long id) {
		edu_formalService.deleteEdu_formal(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
