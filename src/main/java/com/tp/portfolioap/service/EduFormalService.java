package com.tp.portfolioap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.portfolioap.model.EduFormal;
import com.tp.portfolioap.repository.EduFormalRepository;
@Service
public class EduFormalService {
	@Autowired
	private EduFormalRepository edu_formalRepository;
	
	public EduFormal addEdu_formal(EduFormal edu_formal) {
		return edu_formalRepository.save(edu_formal);
	}
	
	public EduFormal findEdu_formalById(Long idEduformal) {
		return edu_formalRepository.findById(idEduformal)
				.orElseThrow(null);
	}
	
	public EduFormal updateEdu_formal(EduFormal edu_formal) {
		return edu_formalRepository.save(edu_formal);
	}
	
	public void deleteEdu_formal(Long idEduformal) {
		edu_formalRepository.deleteById(idEduformal);
	}
}
