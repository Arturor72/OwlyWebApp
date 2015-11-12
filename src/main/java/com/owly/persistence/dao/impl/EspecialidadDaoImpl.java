package com.owly.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.owly.persistence.dao.EspecialidadDao;
import com.owly.persistence.model.Especialidad;

@Repository
public class EspecialidadDaoImpl implements EspecialidadDao{
	
	EntityManager em=null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Especialidad> getEspecialidades() {
			String query="Select e from Especialidad e";
			Query prepareQuery= em.createQuery(query);
		return prepareQuery.getResultList();
	}
}
