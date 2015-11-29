package com.owly.service;

import java.util.List;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
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

	public List<Especialidad> getEspecialidades() {
		List<Especialidad> especialidades = especialidadDao.getEspecialidades();
		return especialidades;
	}

	public void insertAlumno(Alumno alumno) throws Exception {
		alumnoDao.insertAlumno(alumno);
	}

	public Alumno getUsername(String username) {
		Alumno alumno = null;
		List<Alumno> alumnos = alumnoDao.getAlumnoByUsername(username);
		if (!alumnos.isEmpty() && alumnos.size() > 0) {
			alumno = alumnos.get(0);
		}
		return alumno;
	}

	public String existUsername(String username) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate4Module());
		String exist = "";
		List<Alumno> alumnos = alumnoDao.getAlumnoByUsername(username);
		if (!alumnos.isEmpty() && alumnos.size() > 0) {
			Alumno alumno = alumnos.get(0);
			System.out.println(alumno.getEspecialidad().getEspDen());
			try {
				exist = mapper.writeValueAsString(alumnos.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return exist;
	}
}
