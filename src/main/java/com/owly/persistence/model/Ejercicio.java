package com.owly.persistence.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Ejercicio")
public class Ejercicio {
	@Id
	@Column(name="ejeId")
	private Integer ejeId;
	@Column(name="ejeDes")
	private String ejeDes;
	@Column(name="ejePat")
	private String ejePat;
	@Column(name="ejeHor")
	private Time ejeHor;
	@Column(name="ejeFec")
	private Date ejeFec;
	@Column(name="ejeReq")
	private String ejeReq;
	
	@ManyToOne
	@JoinColumn(name="estId")
	private EstadoEjercicio estadoEjercicio;
	@ManyToOne
	@JoinColumn(name="nivUrgId")
	private NivelUrgencia nivelUrgencia;
	@ManyToOne
	@JoinColumn(name="aluId")
	private Alumno alumno;
	@ManyToOne
	@JoinColumn(name="solImgId")
	private SolucionImg solImg;
	@ManyToOne
	@JoinColumn(name="tutId")
	private Tutor tutor;
	
	@ManyToMany
	@JoinTable(name="EjercicioTema",
	joinColumns={@JoinColumn(name="Ejercicio_ejeId", referencedColumnName="ejeId")},
	inverseJoinColumns={@JoinColumn(name="Tema_temId", referencedColumnName="temId")})
	private List<Tema> temas;
	
	@OneToMany(mappedBy="ejeId")
	private List<Postulacion> postulacion;
	
	public Integer getEjeId() {
		return ejeId;
	}
	public void setEjeId(Integer ejeId) {
		this.ejeId = ejeId;
	}
	public String getEjeDes() {
		return ejeDes;
	}
	public void setEjeDes(String ejeDes) {
		this.ejeDes = ejeDes;
	}
	public String getEjePat() {
		return ejePat;
	}
	public void setEjePat(String ejePat) {
		this.ejePat = ejePat;
	}
	public Time getEjeHor() {
		return ejeHor;
	}
	public void setEjeHor(Time ejeHor) {
		this.ejeHor = ejeHor;
	}
	public Date getEjeFec() {
		return ejeFec;
	}
	public void setEjeFec(Date ejeFec) {
		this.ejeFec = ejeFec;
	}
	public String getEjeReq() {
		return ejeReq;
	}
	public void setEjeReq(String ejeReq) {
		this.ejeReq = ejeReq;
	}
	public EstadoEjercicio getEstadoEjercicio() {
		return estadoEjercicio;
	}
	public void setEstadoEjercicio(EstadoEjercicio estadoEjercicio) {
		this.estadoEjercicio = estadoEjercicio;
	}
	public NivelUrgencia getNivelUrgencia() {
		return nivelUrgencia;
	}
	public void setNivelUrgencia(NivelUrgencia nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public SolucionImg getSolImg() {
		return solImg;
	}
	public void setSolImg(SolucionImg solImg) {
		this.solImg = solImg;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	public List<Postulacion> getPostulacion() {
		return postulacion;
	}
	public void setPostulacion(List<Postulacion> postulacion) {
		this.postulacion = postulacion;
	}
	
	
	
}
