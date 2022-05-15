package com.tp.portfolioap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tp.portfolioap.model.Proyecto;
import com.tp.portfolioap.repository.ProyectoRepository;

@Service
public class ProyectoService {
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	public List<Proyecto> findAllProyecto(){
		return proyectoRepository.findAll();
	}
	
	public Proyecto addProyecto(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}
	
	public Proyecto findProyectoById(Long idProyecto) {
		return proyectoRepository.findById(idProyecto)
				.orElseThrow(null);
	}
	
	public Proyecto updateProyecto(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}
	
	public void deleteProyecto(Long idProyecto) {
		proyectoRepository.deleteById(idProyecto);
	}
}
