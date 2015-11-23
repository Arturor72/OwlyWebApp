package com.owly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owly.persistence.dao.EspecialidadDao;
import com.owly.persistence.model.Especialidad;

@Service
public class OwlyServiceEspecialidad {
	
	@Autowired
	EspecialidadDao especialidadDao;
	
	public Especialidad getEspecialidad(Integer idEsp){
		Especialidad especialidad=null;
		List<Especialidad> especialidades=especialidadDao.getEspecialidadById(idEsp);
		if(!especialidades.isEmpty() && especialidades.size()>0){
			especialidad=especialidades.get(0);
		}
		return especialidad;
	}

}
