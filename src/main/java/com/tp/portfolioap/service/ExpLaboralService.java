package com.tp.portfolioap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tp.portfolioap.model.ExpLaboral;
import com.tp.portfolioap.repository.ExpLaboralRepository;
@Service
public class ExpLaboralService {
	@Autowired
	private ExpLaboralRepository exp_laboralRepository;
	
	public List<ExpLaboral> findAllExperiencia(){
		return exp_laboralRepository.findAll();
	}
	
	public ExpLaboral addExp_laboral(ExpLaboral exp_laboral) {
		return exp_laboralRepository.save(exp_laboral);
	}
	
	public ExpLaboral findExp_laboralById(Long idExp_laboral) {
		return exp_laboralRepository.findById(idExp_laboral)
				.orElse(null);
	}
	
	public ExpLaboral updateExp_laboral(ExpLaboral exp_laboral) {
		return exp_laboralRepository.save(exp_laboral);
	}
	
	public void deleteExp_laboral(Long idExp_laboral) {
		exp_laboralRepository.deleteById(idExp_laboral);
	}
}
