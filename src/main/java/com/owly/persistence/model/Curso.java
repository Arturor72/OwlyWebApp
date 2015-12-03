package com.owly.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Curso")
public class Curso {
	@Id
	@Column(name="curId")
	private Integer curId;
	@Column(name="curCod")
	private String curCod;
	@Column(name="curDes")
	private String curDes;
	@OneToMany(mappedBy="curso", fetch=FetchType.LAZY)
	private List<Tema> temas;
		
	public Integer getCurId() {
		return curId;
	}
	public void setCurId(Integer curId) {
		this.curId = curId;
	}
	public String getCurCod() {
		return curCod;
	}
	public void setCurCod(String curCod) {
		this.curCod = curCod;
	}
	public String getCurDes() {
		return curDes;
	}
	public void setCurDes(String curDes) {
		this.curDes = curDes;
	}
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	
}
