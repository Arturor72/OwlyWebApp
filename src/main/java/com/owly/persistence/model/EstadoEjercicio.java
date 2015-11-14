package com.owly.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EstadoEjercicio")
public class EstadoEjercicio {
	
	@Id
	@Column(name="estEjeId")
	private Integer estEjeId;
	@Column(name="estEjeDes")
	private Integer estEjeDes;
	@OneToMany(mappedBy="estadoEjercicio")
	private List<Ejercicio> ejercicios;
	public Integer getEstEjeId() {
		return estEjeId;
	}
	public void setEstEjeId(Integer estEjeId) {
		this.estEjeId = estEjeId;
	}
	public Integer getEstEjeDes() {
		return estEjeDes;
	}
	public void setEstEjeDes(Integer estEjeDes) {
		this.estEjeDes = estEjeDes;
	}
	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

}
