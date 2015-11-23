package com.owly.persistence.dao;

import java.util.List;

import com.owly.persistence.model.Alumno;

public interface AlumnoDao {
	
	public Alumno getAlumnobyId(Integer id);
	public Alumno getAlumnobyUsername(String username);
	public Alumno getAlumnobyUsernameandPassword(String username, String password);
	public List<Alumno> getAlumnos();
	public List<Alumno> getAlumnosbyEspecialidad(Integer idEsp);
	
	public void insertAlumno(Alumno alumno) throws Exception;
	
	public List<Alumno> getAlumnoByUsername(String username);
//	public String updateAlumno(Alumno alumno);
//	public String deleteAlumnos(List<Integer>ids);
}
