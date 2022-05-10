package com.tp.portfolioap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.portfolioap.exception.UserNotFoundException;
import com.tp.portfolioap.model.Persona;
import com.tp.portfolioap.repository.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	private PersonaRepository personaRepository;
	
	public Persona addPersona(Persona persona) {
		return personaRepository.save(persona);
	}
	
	public List<Persona> findAllPersona(){
		return personaRepository.findAll();
	}
	public Persona updatepersona(Persona persona) {
		return personaRepository.save(persona);
	}
	public Persona findPersonaById(Long idPersona) {
		return personaRepository.findById(idPersona)
				.orElseThrow(()-> new UserNotFoundException("Usuario por id " + idPersona + " no fue encontrado."));
	}
	
	public void deletePersona(Long idPersona) {
		personaRepository.deleteById(idPersona);
	}

}
