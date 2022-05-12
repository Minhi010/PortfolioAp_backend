package com.tp.portfolioap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.portfolioap.model.Curso;
import com.tp.portfolioap.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso addCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public Curso findCursoById(Long idCurso) {
		return cursoRepository.findById(idCurso)
				.orElseThrow(null);
	}
	
	public Curso updateCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public void deleteCurso(Long idCurso) {
		cursoRepository.deleteById(idCurso);
	}
	
}
