package com.tp.portfolioap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.portfolioap.exception.UserNotFoundException;
import com.tp.portfolioap.model.Persona;
import com.tp.portfolioap.repo.PersonaRepo;

@Service
public class PersonaService {
	@Autowired
	private PersonaRepo personaRepo;
	
	public Persona addPersona(Persona persona) {
		return personaRepo.save(persona);
	}
	
	public List<Persona> findAllPersona(){
		return personaRepo.findAll();
	}
	public Persona updatepersona(Persona persona) {
		return personaRepo.save(persona);
	}
	public Persona findPersonaById(Long idPersona) {
		return personaRepo.findById(idPersona)
				.orElseThrow(()-> new UserNotFoundException("Usuario por id " + idPersona + " no fue encontrado."));
	}
	
	public void deletePersona(Long idPersona) {
		personaRepo.deleteById(idPersona);
	}
	public Persona findByEmail(String mail) {
		return personaRepo.findByMail(mail).orElse(null);
	}
}
