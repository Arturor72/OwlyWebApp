package com.owly.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NivelUrgencia")
public class NivelUrgencia {
	@Id
	@Column(name="nivUrgId")
	private Integer nivUrgId;
	@Column(name="nivUrgDes")
	private String nivUrgDes;
	@OneToMany(mappedBy="nivelUrgencia")
	private List<Ejercicio> ejercicios;
	
	public Integer getNivUrgId() {
		return nivUrgId;
	}
	public void setNivUrgId(Integer nivUrgId) {
		this.nivUrgId = nivUrgId;
	}
	public String getNivUrgDes() {
		return nivUrgDes;
	}
	public void setNivUrgDes(String nivUrgDes) {
		this.nivUrgDes = nivUrgDes;
	}
	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	

}
