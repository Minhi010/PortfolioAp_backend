package com.tp.portfolioap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.portfolioap.model.Exp_laboral;
import com.tp.portfolioap.repository.Exp_laboralRepository;
@Service
public class Exp_laboralService {
	@Autowired
	private Exp_laboralRepository exp_laboralRepository;
	
	public Exp_laboral addExp_laboral(Exp_laboral exp_laboral) {
		return exp_laboralRepository.save(exp_laboral);
	}
	
	public Exp_laboral findExp_laboralById(Long idExp_laboral) {
		return exp_laboralRepository.findById(idExp_laboral)
				.orElse(null);
	}
	
	public Exp_laboral updateExp_laboral(Exp_laboral exp_laboral) {
		return exp_laboralRepository.save(exp_laboral);
	}
	
	public void deleteExp_laboral(Long idExp_laboral) {
		exp_laboralRepository.deleteById(idExp_laboral);
	}
}
