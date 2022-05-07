package com.tp.portfolioap.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.portfolioap.model.Persona;

public interface PersonaRepo extends JpaRepository<Persona, Long>{
	Optional<Persona> findByMail(String mail);
}