package com.owly.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Tutor")
public class Tutor {
	
	@Id
	@Column(name="tutId")
	private Integer tutId;
	@Column(name="tutCod")
	private String tutCod;
	@Column(name="tutApePat")
	private String tutApePat;
	@Column(name="tutApeMat")
	private String tutApeMat;
	@Column(name="tutNom")
	private String tutNom;
	@Column(name="tutEda")
	private Integer tutEda;
	@Column(name="tutDni")
	private String tutDni;
	@Column(name="tutUsu")
	private String tutUsu;
	@Column(name="tutPas")
	private String tutPas;
	@Column(name="tutPuntos")
	private Integer tutPuntos;
	@ManyToOne
	@JoinColumn(name="nivId")
	private Nivel nivel;
	
	@OneToMany(mappedBy="tutor")
	private List<Ejercicio> ejercicios;
	
	@OneToMany(mappedBy="tutId")
	private List<Postulacion> postulacion;
	
	@OneToMany(mappedBy="tutor")
	private List<SolucionImg> solImgs;
	
	public Integer getTutId() {
		return tutId;
	}
	public void setTutId(Integer tutId) {
		this.tutId = tutId;
	}
	public String getTutCod() {
		return tutCod;
	}
	public void setTutCod(String tutCod) {
		this.tutCod = tutCod;
	}
	public String getTutApePat() {
		return tutApePat;
	}
	public void setTutApePat(String tutApePat) {
		this.tutApePat = tutApePat;
	}
	public String getTutApeMat() {
		return tutApeMat;
	}
	public void setTutApeMat(String tutApeMat) {
		this.tutApeMat = tutApeMat;
	}
	public String getTutNom() {
		return tutNom;
	}
	public void setTutNom(String tutNom) {
		this.tutNom = tutNom;
	}
	public Integer getTutEda() {
		return tutEda;
	}
	public void setTutEda(Integer tutEda) {
		this.tutEda = tutEda;
	}
	public String getTutDni() {
		return tutDni;
	}
	public void setTutDni(String tutDni) {
		this.tutDni = tutDni;
	}
	public String getTutUsu() {
		return tutUsu;
	}
	public void setTutUsu(String tutUsu) {
		this.tutUsu = tutUsu;
	}
	public String getTutPas() {
		return tutPas;
	}
	public void setTutPas(String tutPas) {
		this.tutPas = tutPas;
	}
	public Integer getTutPuntos() {
		return tutPuntos;
	}
	public void setTutPuntos(Integer tutPuntos) {
		this.tutPuntos = tutPuntos;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	public List<Postulacion> getPostulacion() {
		return postulacion;
	}
	public void setPostulacion(List<Postulacion> postulacion) {
		this.postulacion = postulacion;
	}
	public List<SolucionImg> getSolImgs() {
		return solImgs;
	}
	public void setSolImgs(List<SolucionImg> solImgs) {
		this.solImgs = solImgs;
	}
	
	
}
