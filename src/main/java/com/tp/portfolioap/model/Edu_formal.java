package com.tp.portfolioap.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Edu_formal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable= false, updatable = false)
	private Long idEduformal;
	private String titulo;
	private String institucion;
	private String fotoInstitucion;
	private String periodo;
	private String descripcion;
	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(name="idPersona")
	@JsonBackReference
	private Persona persona;

	
}
