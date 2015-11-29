package com.owly.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.owly.constants.OwlyConstants;
import com.owly.persistence.dao.AlumnoDao;
import com.owly.persistence.dao.TutorDao;
import com.owly.persistence.model.Alumno;
import com.owly.persistence.model.Tutor;

public class OwlyUserService implements UserDetailsService {

	AlumnoDao alumnoDao;

	TutorDao tutorDao;

	public OwlyUserService() {
	}

	public void setAlumnoDao(AlumnoDao alumnoDao) {
		this.alumnoDao = alumnoDao;
	}

	public void setTutorDao(TutorDao tutorDao) {
		this.tutorDao = tutorDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		List<Alumno> alumnos = alumnoDao.getAlumnoByUsername(username);
		List<Tutor>  tutores = tutorDao.getTutorByUser(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		User usuario=null;
		if (!alumnos.isEmpty() && alumnos.size()> 0) {
			usuario=getUserAlumno(authorities, alumnos);
		} else if (!tutores.isEmpty() && tutores.size()> 0) {
			usuario=getUserTutor(authorities, tutores);
		}
		else{
			throw new UsernameNotFoundException(username + "not found");
		}
		
		return usuario;
	}
	
	private User getUserAlumno(List<GrantedAuthority> authorities, List<Alumno> alumnos ){
		Alumno alumno=alumnos.get(0);
		authorities.add(new SimpleGrantedAuthority(OwlyConstants.ROLE_ALUMNO));
		User usuario=new User(alumno.getAluUsu(), alumno.getAluPas(), authorities); 
		
		System.out.println(alumno.getAluNom() + " " + alumno.getAluPas());
		return usuario;
	}
	private User getUserTutor(List<GrantedAuthority> authorities, List<Tutor> tutores ){
		Tutor tutor=tutores.get(0);
		authorities.add(new SimpleGrantedAuthority(OwlyConstants.ROLE_TUTOR));		
		User usuario=new User(tutor.getTutUsu(), tutor.getTutPas(), authorities);
		System.out.println(tutor.getTutNom() + " " + tutor.getTutPas());
		return usuario;
	}

}
