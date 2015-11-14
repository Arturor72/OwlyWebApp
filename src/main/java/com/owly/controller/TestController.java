package com.owly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.owly.persistence.dao.AlumnoDao;
import com.owly.persistence.dao.EspecialidadDao;
import com.owly.persistence.dao.UniversidadDao;
import com.owly.persistence.model.Alumno;
import com.owly.persistence.model.Especialidad;
import com.owly.persistence.model.Universidad;

@Controller
public class TestController {
   
	@Autowired
	UniversidadDao universidadDao;
	
	@Autowired
	EspecialidadDao especialidadDao;
	
	@Autowired
	AlumnoDao alumnoDao;
    
	@RequestMapping(method=RequestMethod.GET, value="/test")
	public String getLogin(){
		List<Universidad> universidadList=universidadDao.getUniversidades();
		for (Universidad universidad : universidadList) {
			System.out.println(universidad.getUniDes());
			for (Especialidad especialidad : universidad.getEspecialidades()) {
				System.out.println(especialidad.getEspDen());
			}
		}
		return "home";	
	}
	@RequestMapping(method=RequestMethod.GET, value="/esp")
	public String getEsp(){
		List<Especialidad> especialidades=especialidadDao.getEspecialidades();
		for (Especialidad especialidad : especialidades) {
			System.out.println(especialidad.getEspDen());
			System.out.println(especialidad.getUniversidad().getUniDes());
		}
		return "home";	
	}

	@RequestMapping(method=RequestMethod.GET, value="/al")
	public String getAl(){
		List<Alumno> alumnos=alumnoDao.getAlumnoByUsername("arturo");
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.getAluNom());
			System.out.println(alumno.getEspecialidad().getEspDen());
		}
		return "home";	
	}
	
}
