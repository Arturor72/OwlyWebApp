package com.owly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="/alumno/")
public class AlumnoController {
@RequestMapping(method=RequestMethod.GET, value="home")	
public String getHome(){

	return "alumno/alumno";
}
}
