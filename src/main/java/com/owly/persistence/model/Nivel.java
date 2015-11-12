package com.owly.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	
}
