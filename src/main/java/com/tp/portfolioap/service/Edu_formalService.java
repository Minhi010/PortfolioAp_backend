package com.tp.portfolioap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.portfolioap.model.Edu_formal;
import com.tp.portfolioap.repository.Edu_formalRepository;
@Service
public class Edu_formalService {
	@Autowired
	private Edu_formalRepository edu_formalRepository;
	
	public Edu_formal addEdu_formal(Edu_formal edu_formal) {
		return edu_formalRepository.save(edu_formal);
	}
	
	public Edu_formal findEdu_formalById(Long idEduformal) {
		return edu_formalRepository.findById(idEduformal)
				.orElseThrow(null);
	}
	
	public Edu_formal updateEdu_formal(Edu_formal edu_formal) {
		return edu_formalRepository.save(edu_formal);
	}
	
	public void deleteEdu_formal(Long idEduformal) {
		edu_formalRepository.deleteById(idEduformal);
	}
}
