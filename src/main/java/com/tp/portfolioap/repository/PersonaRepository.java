package com.tp.portfolioap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.portfolioap.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	Optional<Persona> findByMail(String mail);
}