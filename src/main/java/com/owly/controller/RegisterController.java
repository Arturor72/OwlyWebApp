package com.owly.controller;

import java.util.List;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.owly.persistence.model.Alumno;
import com.owly.persistence.model.Especialidad;
import com.owly.service.OwlyAlumnoService;
import com.owly.service.OwlyServiceEspecialidad;

@Controller
public class RegisterController {

	@Autowired
	OwlyAlumnoService alumnoService;
	
	@Autowired
	OwlyServiceEspecialidad especialidadService;
	
	@RequestMapping(method=RequestMethod.GET, value="/registro")
	public String getRegister(Model model){
		List<Especialidad> especialidades= alumnoService.getEspecialidades();
		model.addAttribute("especialidades",especialidades);
		return "RegistroAlumno";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registro")
	public String SignAlumno(Alumno alumno, @RequestParam("aluEsp") String idEsp ) throws Exception{
		Integer idEspecialidad=Integer.parseInt(idEsp.trim());
		Especialidad especialidadAlumno=especialidadService.getEspecialidad(idEspecialidad);
		alumno.setEspecialidad(especialidadAlumno);

			alumnoService.insertAlumno(alumno);	

		return "RegistroAlumno";
	}
	
}
