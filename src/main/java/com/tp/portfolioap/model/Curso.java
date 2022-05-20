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
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable= false, updatable = false)
	private Long id;
	private String nombre;
	private String institucion;
	private String foto;
	private String duracion;
	private String descripcion;
	private String enlace;
	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(name="idPersona")
	@JsonBackReference
	private Persona persona;
}
