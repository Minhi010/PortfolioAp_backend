package com.tp.portfolioap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tp.portfolioap.model.Habilidad;
import com.tp.portfolioap.repository.HabilidadRepository;
@Service
public class HabilidadService {
	@Autowired
	private HabilidadRepository habilidadRepository;
	
	public List<Habilidad> findAllHabilidades(){
		return habilidadRepository.findAll();
	}
	
	public Habilidad addHabilidad(Habilidad habilidad) {
		return habilidadRepository.save(habilidad);
	}
	
	public Habilidad findHabilidadById(Long idHabilidad) {
		return habilidadRepository.findById(idHabilidad)
				.orElse(null);
	}
	
	public Habilidad updateHabilidad(Habilidad habilidad) {
		return habilidadRepository.save(habilidad);
	}
	
	public void deleteHabilidad(Long idhabilidad) {
		habilidadRepository.deleteById(idhabilidad);
	}
}
