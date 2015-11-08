package com.owly.persitence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

}
