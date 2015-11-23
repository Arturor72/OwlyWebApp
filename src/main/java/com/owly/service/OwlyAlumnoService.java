package com.owly.service;

import java.util.List;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owly.persistence.dao.AlumnoDao;
import com.owly.persistence.dao.EspecialidadDao;
import com.owly.persistence.model.Alumno;
import com.owly.persistence.model.Especialidad;

@Service
public class OwlyAlumnoService {
	@Autowired
	EspecialidadDao especialidadDao;
	
	@Autowired
	AlumnoDao alumnoDao;
	
	public List<Especialidad> getEspecialidades(){
		List<Especialidad> especialidades=especialidadDao.getEspecialidades();
		return especialidades;
	}
	
	public void insertAlumno(Alumno alumno) throws Exception{
		alumnoDao.insertAlumno(alumno);
	}
}
