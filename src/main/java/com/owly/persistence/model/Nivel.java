package com.owly.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Nivel")
public class Nivel {
	
	@Id
	@Column(name="nivId")
	private Integer nivId;
	@Column(name="nivCod")
	private String nivCod;
	@Column(name="nivDes")
	private String nivDes;
	
	@OneToMany(mappedBy="nivel")
	private List<Tutor> tutores;
	
	public Integer getNivId() {
		return nivId;
	}
	public void setNivId(Integer nivId) {
		this.nivId = nivId;
	}
	public String getNivCod() {
		return nivCod;
	}
	public void setNivCod(String nivCod) {
		this.nivCod = nivCod;
	}
	public String getNivDes() {
		return nivDes;
	}
	public void setNivDes(String nivDes) {
		this.nivDes = nivDes;
	}
	public List<Tutor> getTutores() {
		return tutores;
	}
	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}
	
	
}
