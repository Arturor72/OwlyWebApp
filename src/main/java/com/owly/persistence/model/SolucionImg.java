package com.owly.persistence.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SolucionImg")
public class SolucionImg {
	@Id
	@Column(name="solImgId")
	private Integer solImgId;
	@Column(name="solImgDes")
	private String solImgDes;
	@Column(name="solImgPat")
	private String solImgPat;
	@Column(name="solImgPun")
	private String solImgPun;
	@Column(name="solImgHor")
	private String solImgHor;
	@Column(name="solImgFec")
	private Time solImgFec;
	@Column(name="solImgPre")
	private Date solImgPre;
	@ManyToOne
	@JoinColumn(name="tutId")
	private Tutor tutor;
	
	@OneToMany(mappedBy="solImg")
	private List<Ejercicio> ejercicios;
	
	public Integer getSolImgId() {
		return solImgId;
	}
	public void setSolImgId(Integer solImgId) {
		this.solImgId = solImgId;
	}
	public String getSolImgDes() {
		return solImgDes;
	}
	public void setSolImgDes(String solImgDes) {
		this.solImgDes = solImgDes;
	}
	public String getSolImgPat() {
		return solImgPat;
	}
	public void setSolImgPat(String solImgPat) {
		this.solImgPat = solImgPat;
	}
	public String getSolImgPun() {
		return solImgPun;
	}
	public void setSolImgPun(String solImgPun) {
		this.solImgPun = solImgPun;
	}
	public String getSolImgHor() {
		return solImgHor;
	}
	public void setSolImgHor(String solImgHor) {
		this.solImgHor = solImgHor;
	}
	public Time getSolImgFec() {
		return solImgFec;
	}
	public void setSolImgFec(Time solImgFec) {
		this.solImgFec = solImgFec;
	}
	public Date getSolImgPre() {
		return solImgPre;
	}
	public void setSolImgPre(Date solImgPre) {
		this.solImgPre = solImgPre;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}
	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	
}
