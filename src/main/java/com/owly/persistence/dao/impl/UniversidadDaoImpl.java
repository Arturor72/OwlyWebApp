package com.owly.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.owly.persistence.dao.UniversidadDao;
import com.owly.persistence.model.Universidad;
import com.owly.persitence.model.Tema;

@Repository
public class UniversidadDaoImpl implements UniversidadDao{
	
	EntityManager em=null;
	
	@PersistenceContext
	public void setEntityManger(EntityManager em){
		this.em=em;
	}
	 
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Universidad> getUniversidades() {
		String query="Select U from Universidad U";
		return em.createQuery(query).getResultList();
	}


}
