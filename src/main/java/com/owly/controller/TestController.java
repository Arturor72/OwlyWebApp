package com.owly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.owly.persistence.dao.TemaDao;
import com.owly.persitence.model.Tema;

@Controller
public class TestController {
    @Autowired
	TemaDao temaDao;
    
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public String getLogin(){
		List<Tema> temas=temaDao.getTemas();
		for (Tema tema : temas) {
			System.out.println(tema.getTemDes());
		}
				
		return "login";	
	}
	

}
