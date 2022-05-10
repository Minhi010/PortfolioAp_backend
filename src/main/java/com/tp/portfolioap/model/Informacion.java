package com.tp.portfolioap.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Informacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInfo;
	private String nombre;
	private String apellido;
	private LocalDate f_nacimiento; 
	private String nacionalidad; 
	private String ocupacion;
	private String mail;
	private String descripcion;
	private String f_perfil;
	private String f_fondo;
	@OneToOne( fetch=FetchType.LAZY)
	@JoinColumn(name="idPersona")
	@JsonBackReference
	private Persona persona;
}
