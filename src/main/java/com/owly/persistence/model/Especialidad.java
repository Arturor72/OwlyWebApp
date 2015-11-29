package com.owly.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="Especialidad")
public class Especialidad {
	
	@Id
	@Column(name="espId")
	private Integer espId;
	
	@Column(name="espCod")
	private String espCod;
	
	@Column(name="espDen")
	private String espDen;
	
	@ManyToOne
	@JoinColumn(name="uniId")
	private Universidad universidad;
	
	@OneToMany(mappedBy="especialidad")
	@JsonManagedReference
	private List<Alumno> alumnos;
	
	public Integer getEspId() {
		return espId;
	}
	public void setEspId(Integer espId) {
		this.espId = espId;
	}
	public String getEspCod() {
		return espCod;
	}
	public void setEspCod(String espCod) {
		this.espCod = espCod;
	}
	public String getEspDen() {
		return espDen;
	}
	public void setEspDen(String espDen) {
		this.espDen = espDen;
	}
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
}
