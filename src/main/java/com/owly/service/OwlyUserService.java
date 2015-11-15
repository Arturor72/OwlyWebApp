package com.owly.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.owly.persistence.dao.AlumnoDao;
import com.owly.persistence.model.Alumno;

public class OwlyUserService implements UserDetailsService{

	
	AlumnoDao alumnoDao;
	
	public OwlyUserService(AlumnoDao alumnoDao) {
		this.alumnoDao=alumnoDao;
	}
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		List<Alumno> alumno=alumnoDao.getAlumnoByUsername(username);
		if(!alumno.isEmpty() && alumno.size()>0){
			List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ALUMNO"));
			System.out.println(alumno.get(0).getAluNom()+" "+alumno.get(0).getAluPas());
			return new User(alumno.get(0).getAluUsu(), alumno.get(0).getAluPas(), authorities);
		}
		throw new UsernameNotFoundException(username+"not found");
	}


}
