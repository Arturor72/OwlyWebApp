package com.owly.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.annotations.Synchronize;
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

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Tema> getTemasByCursoId(Integer curId) {
		String query="Select t from Tema t where t.curso.curId=:curId";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("curId", curId);
		return prepareQuery.getResultList();
	}
	
}
