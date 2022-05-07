package com.tp.portfolioap.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable= false, updatable = false)
	private Long idPersona;
	private String nombre;
	private String apellido;
	private LocalDate f_nacimiento; 
	private String nacionalidad; 
	private String ocupacion;
	private String mail;
	private String contraseña;
	private String descripcion;
	private String f_perfil;
	private String f_fondo;
	private Boolean admin; 
}
