package com.owly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.owly.persistence.dao.TemaDao;
import com.owly.persistence.model.Tema;

@Service
public class OwlyTemaService {
	
	@Autowired
	TemaDao temaDao;
	
	public String getTemaByCurso(Integer cursoId) throws Exception{
		String temasAsString="";
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.registerModule(new Hibernate4Module());
		List<Tema> temas=temaDao.getTemasByCursoId(cursoId);
		if(temas!=null && temas.size()>0){
			temasAsString = mapper.writeValueAsString(temas);	
		}
		return temasAsString;
	}

}
