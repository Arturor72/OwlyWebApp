package com.owly.persistence.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Postulacion")
public class Postulacion implements Serializable{
	
	@Id 
	@ManyToOne
	@JoinColumn(name="ejeId")
	private Ejercicio ejeId;
	@Id
	@ManyToOne
	@JoinColumn(name="tutId")
	private Tutor tutId;
	@Column(name="posPre")
	private Double posPre;
	@Column(name="posHor")
	private Time posHor;
	@Column(name="posFec")
	private Date posFec;
	
	public Ejercicio getEjeId() {
		return ejeId;
	}
	public void setEjeId(Ejercicio ejeId) {
		this.ejeId = ejeId;
	}
	public Tutor getTutId() {
		return tutId;
	}
	public void setTutId(Tutor tutId) {
		this.tutId = tutId;
	}
	public Double getPosPre() {
		return posPre;
	}
	public void setPosPre(Double posPre) {
		this.posPre = posPre;
	}
	public Time getPosHor() {
		return posHor;
	}
	public void setPosHor(Time posHor) {
		this.posHor = posHor;
	}
	public Date getPosFec() {
		return posFec;
	}
	public void setPosFec(Date posFec) {
		this.posFec = posFec;
	}
	
	
	

}
