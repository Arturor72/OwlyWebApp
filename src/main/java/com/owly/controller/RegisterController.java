package com.owly.controller;

import java.util.List;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.owly.persistence.model.Alumno;
import com.owly.persistence.model.Especialidad;
import com.owly.service.OwlyAlumnoService;
import com.owly.service.OwlyServiceEspecialidad;

@Controller
@RequestMapping(value="/registro")
public class RegisterController {

	@Autowired
	OwlyAlumnoService alumnoService;
	
	@Autowired
	OwlyServiceEspecialidad especialidadService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getRegister(Model model){
		List<Especialidad> especialidades= alumnoService.getEspecialidades();
		model.addAttribute("especialidades",especialidades);
		return "RegistroAlumno";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String SignAlumno(Alumno alumno, @RequestParam("aluEsp") String idEsp ) throws Exception{
		Integer idEspecialidad=Integer.parseInt(idEsp.trim());
		Especialidad especialidadAlumno=especialidadService.getEspecialidad(idEspecialidad);
		alumno.setEspecialidad(especialidadAlumno);

			alumnoService.insertAlumno(alumno);	

		return "RegistroAlumno";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getUsername")
	public @ResponseBody String verifyUsername(@RequestBody String user) throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		JsonNode jnode=mapper.readTree(user);
		String username=jnode.get("user").asText();
		String alumnoExist=alumnoService.existUsername(username);
		System.out.println("Response: "+alumnoExist);
		return alumnoExist;
	}
}
