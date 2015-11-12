package com.owly.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Universidad")
public class Universidad {

	@Id
	@Column(name = "uniId")
	private Integer uniId;
	
	@Column(name = "uniCod")
	private String uniCod;
	
	@Column(name = "uniDes")
	private String uniDes;

	@OneToMany(mappedBy = "universidad")
	private List<Especialidad> especialidades;

	public Integer getUniId() {
		return uniId;
	}

	public void setUniId(Integer uniId) {
		this.uniId = uniId;
	}

	public String getUniCod() {
		return uniCod;
	}

	public void setUniCod(String uniCod) {
		this.uniCod = uniCod;
	}

	public String getUniDes() {
		return uniDes;
	}

	public void setUniDes(String uniDes) {
		this.uniDes = uniDes;
	}

	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

}
