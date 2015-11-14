package com.owly.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.owly.persistence.dao.TemaDao;
import com.owly.persistence.model.Tema;

@Repository
public class TemaDaoImpl implements TemaDao{
	EntityManager em=null;
	
	@PersistenceContext
	public void setEntityManger(EntityManager em){
		this.em=em;
	}
	

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Tema> getTemas() {
		String query="Select t from Tema t";
		return em.createQuery(query).getResultList();
	}

}
