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
import com.tp.portfolioap.model.Informacion;
import com.tp.portfolioap.model.Persona;
import com.tp.portfolioap.service.InformacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/informacion")
@RequiredArgsConstructor
public class InformacionController {
	private final InformacionService informacionService;
	private final Long IDPERSONA=1L; 

	@GetMapping("/all")
	public ResponseEntity<List<Informacion>>getAllInformacion(){
		List<Informacion> informacion = informacionService.findAllInformacion();
		return new ResponseEntity<>(informacion, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Informacion> getInformacionById(@PathVariable("id") Long id) {
		Informacion informacion = informacionService.findInformacionById(id);
		return new ResponseEntity<>(informacion, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Informacion> addInformacion(@RequestBody Informacion informacion) {
		Persona p = new Persona();
		p.setId(IDPERSONA);
		informacion.setPersona(p);
		
		Informacion informaciones = informacionService.addInformacion(informacion);
		return new ResponseEntity<>(informaciones, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateInformacion(@RequestBody Informacion informacion) {
		Informacion nuevainfo = informacionService.findInformacionById(informacion.getId()); 
		if (nuevainfo==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		Persona p = new Persona();
		p.setId(IDPERSONA);
		informacion.setPersona(p);
				
		Informacion updateInformacion = informacionService.addInformacion(informacion);
		return new ResponseEntity<>(updateInformacion, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteInformacion(@PathVariable("id") Long id) {
		informacionService.deleteInformacion(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
