package com.owly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.owly.persistence.model.Curso;
import com.owly.service.OwlyCursoService;
import com.owly.service.OwlyTemaService;

@Controller
public class EjercicioController {
	
	@Autowired
	OwlyCursoService cursoService;
	
	@Autowired
	OwlyTemaService temaService;
	
	@RequestMapping(value="/alumno/nejercicio", method=RequestMethod.GET)
	public String getCursoFomulario(Model model) throws Exception{
		String view="alumno/EjercicioNuevo";
		List<Curso> listaCursos=cursoService.getCursos();
		model.addAttribute("cursos", listaCursos);
		return view;
	}
	
	@RequestMapping(value="/alumno/sendCursoId", method=RequestMethod.POST)
	public @ResponseBody String getTemasFomulario(@RequestBody String cursoId) throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		JsonNode jnode=mapper.readTree(cursoId);
		String cursoIdasString=jnode.get("cursoId").asText();
		Integer cursoIdConverted=Integer.parseInt(cursoIdasString.trim());
		String temasAsStringJson= temaService.getTemaByCurso(cursoIdConverted);
		return temasAsStringJson;
	}
//	sendCursoId
}
