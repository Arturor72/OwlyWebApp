package com.owly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owly.persistence.dao.CursoDao;
import com.owly.persistence.model.Curso;

@Service
public class OwlyCursoService {
	@Autowired
	CursoDao cursoDao;
	
	public List<Curso> getCursos(){
		List<Curso> listaCursos=cursoDao.getCursos();
		return listaCursos;
	}
}
