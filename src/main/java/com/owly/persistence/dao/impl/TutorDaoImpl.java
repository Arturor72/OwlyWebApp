package com.owly.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.owly.persistence.dao.TutorDao;
import com.owly.persistence.model.Tutor;

@Repository
public class TutorDaoImpl implements TutorDao{

	EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}
	
	@Override
	public List<Tutor>  getTutorById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Tutor> getTutorByUser(String username) {
		String query="Select t from Tutor t where t.tutUsu= :username";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("username", username);
		return prepareQuery.getResultList();
	}
	@Override
	public List<Tutor> getTutores() {
		// TODO Auto-generated method stub
		return null;
	}
}
