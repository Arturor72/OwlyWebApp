package com.owly.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tema")
public class Tema {
	@Id
	@Column(name = "temId")
	private Integer temId;
	@Column(name = "temCod")
	private String temCod;
	@Column(name = "temDes")
	private String temDes;
	@ManyToOne
	@JoinColumn(name="curId")
	private Curso curso;
	
	@ManyToMany
	@JoinTable(name="EjercicioTema",
	joinColumns={@JoinColumn(name="Tema_temId", referencedColumnName="temId")},
	inverseJoinColumns={@JoinColumn(name="Ejercicio_ejeId", referencedColumnName="ejeId")})
	private List<Ejercicio> ejercicios;
	
	
	public Integer getTemId() {
		return temId;
	}

	public void setTemId(Integer temId) {
		this.temId = temId;
	}

	public String getTemCod() {
		return temCod;
	}

	public void setTemCod(String temCod) {
		this.temCod = temCod;
	}

	public String getTemDes() {
		return temDes;
	}

	public void setTemDes(String temDes) {
		this.temDes = temDes;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

}
