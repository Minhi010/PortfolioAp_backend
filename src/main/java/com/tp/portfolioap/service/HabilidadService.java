package com.tp.portfolioap.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.portfolioap.model.Habilidad;
import com.tp.portfolioap.repository.HabilidadRepository;

public class HabilidadService {
	@Autowired
	private HabilidadRepository habilidadRepository;
	
	public Habilidad addHabilidad(Habilidad habilidad) {
		return habilidadRepository.save(habilidad);
	}
	
	public Habilidad findHabilidadById(Long idHabilidad) {
		return habilidadRepository.findById(idHabilidad)
				.orElseThrow(null);
	}
	
	public Habilidad updateHabilidad(Habilidad habilidad) {
		return habilidadRepository.save(habilidad);
	}
	
	public void deleteHabilidad(Long idhabilidad) {
		habilidadRepository.deleteById(idhabilidad);
	}
}
