package com.tp.portfolioap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.portfolioap.model.Informacion;
import com.tp.portfolioap.repository.InformacionRepository;
@Service
public class InformacionService {
	@Autowired
	private InformacionRepository informacionRepository;
	
	public Informacion addInformacion(Informacion informacion) {
		return informacionRepository.save(informacion);
	}
	
	public Informacion findInformacionById(Long idInformacion) {
		return informacionRepository.findById(idInformacion)
				.orElseThrow(null);
	}
	
	public Informacion updateInformacion(Informacion informacion) {
		return informacionRepository.save(informacion);
	}
	
	public void deleteInformacion(Long idInformacion) {
		informacionRepository.deleteById(idInformacion);
	}
}
