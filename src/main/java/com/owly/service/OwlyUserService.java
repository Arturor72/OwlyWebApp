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
		if (!alumnos.isEmpty() || alumnos.size()> 0) {
			Alumno alumno=alumnos.get(0);
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(OwlyConstants.ROLE_ALUMNO));
			System.out.println(alumno.getAluNom() + " " + alumno.getAluPas());
			return new User(alumno.getAluUsu(), alumno.getAluPas(), authorities);
		} else {
			List<Tutor>  tutores = tutorDao.getTutorByUser(username);
			if (!tutores.isEmpty() || tutores.size()> 0) {
				Tutor tutor=tutores.get(0);
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority(OwlyConstants.ROLE_TUTOR));
				System.out
						.println(tutor.getTutNom() + " " + tutor.getTutPas());
				return new User(tutor.getTutUsu(), tutor.getTutPas(),
						authorities);
			}
		}
		throw new UsernameNotFoundException(username + "not found");
	}

}
