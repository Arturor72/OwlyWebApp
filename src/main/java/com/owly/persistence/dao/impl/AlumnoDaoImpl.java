package com.owly.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.owly.persistence.dao.AlumnoDao;
import com.owly.persistence.model.Alumno;

@Repository
public class AlumnoDaoImpl implements AlumnoDao {

	EntityManager em=null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}

	@Override
	public Alumno getAlumnobyId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno getAlumnobyUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno getAlumnobyUsernameandPassword(String username,
			String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Alumno> getAlumnos() {
		String query="Select a from Alumno a";
		Query prepareQuery=em.createQuery(query);
		return prepareQuery.getResultList();
	}

	@Override
	public List<Alumno> getAlumnosbyEspecialidad(Integer idEsp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
