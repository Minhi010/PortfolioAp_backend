package com.tp.portfolioap.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable= false, updatable = false)
	private Long idPersona;
	@OneToOne(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference
	private Informacion informacion;
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Habilidad> habilidades;
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Curso> cursos;
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Edu_formal> eduFormal;
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Exp_laboral> expLaboral;
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Proyecto> proyectos;
	
}
