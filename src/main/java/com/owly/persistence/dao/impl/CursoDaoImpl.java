package com.owly.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.owly.persistence.dao.CursoDao;
import com.owly.persistence.model.Curso;

@Repository
public class CursoDaoImpl implements CursoDao{
	
	EntityManager em=null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}
	
	
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Curso> getCursos() {
		String query="Select c from Curso c";
		Query prepareQuery=em.createQuery(query);
		return prepareQuery.getResultList();
	}
	

}
