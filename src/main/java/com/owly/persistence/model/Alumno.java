package com.owly.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Alumno")
public class Alumno {
	@Id
	@Column(name = "aluId")
	private Integer aluId;
	@Column(name = "aluCod")
	private String aluCod;
	@Column(name = "aluApePat")
	private String aluApePat;
	@Column(name = "aluApeMat")
	private String aluApeMat;
	@Column(name = "aluNom")
	private String aluNom;
	@Column(name = "aluEda")
	private Integer aluEda;
	@Column(name = "aluDni")
	private String aluDni;
	@Column(name = "aluUsu")
	private String aluUsu;
	@Column(name = "aluPas")
	private String aluPas;
	@Column(name = "aluEma")
	private String aluEma;
	@ManyToOne
	@JoinColumn(name = "espId")
	private Especialidad especialidad;

	public Integer getAluId() {
		return aluId;
	}

	public void setAluId(Integer aluId) {
		this.aluId = aluId;
	}

	public String getAluCod() {
		return aluCod;
	}

	public void setAluCod(String aluCod) {
		this.aluCod = aluCod;
	}

	public String getAluApePat() {
		return aluApePat;
	}

	public void setAluApePat(String aluApePat) {
		this.aluApePat = aluApePat;
	}

	public String getAluApeMat() {
		return aluApeMat;
	}

	public void setAluApeMat(String aluApeMat) {
		this.aluApeMat = aluApeMat;
	}

	public String getAluNom() {
		return aluNom;
	}

	public void setAluNom(String aluNom) {
		this.aluNom = aluNom;
	}

	public Integer getAluEda() {
		return aluEda;
	}

	public void setAluEda(Integer aluEda) {
		this.aluEda = aluEda;
	}

	public String getAluDni() {
		return aluDni;
	}

	public void setAluDni(String aluDni) {
		this.aluDni = aluDni;
	}

	public String getAluUsu() {
		return aluUsu;
	}

	public void setAluUsu(String aluUsu) {
		this.aluUsu = aluUsu;
	}

	public String getAluPas() {
		return aluPas;
	}

	public void setAluPas(String aluPas) {
		this.aluPas = aluPas;
	}

	public String getAluEma() {
		return aluEma;
	}

	public void setAluEma(String aluEma) {
		this.aluEma = aluEma;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

}
