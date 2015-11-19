package com.owly.persistence.dao;

import java.util.List;

import com.owly.persistence.model.Tutor;

public interface TutorDao {
	public List<Tutor> getTutores();
	public List<Tutor>  getTutorById(Integer id);
	public List<Tutor>  getTutorByUser(String username);
	
	
}
