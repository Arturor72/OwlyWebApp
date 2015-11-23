package com.owly.persistence.dao;

import java.util.List;

import com.owly.persistence.model.Especialidad;

public interface EspecialidadDao {

	public List <Especialidad> getEspecialidades();
	
	public List<Especialidad> getEspecialidadById( Integer idEsp);
}
