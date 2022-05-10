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
public class Exp_laboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable= false, updatable = false)
	private Long idExplaboral;
	private String trabajo;
	private String periodo;
	private String descripcion;
	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(name="idPersona")
	@JsonBackReference
	private Persona persona;
	
}
