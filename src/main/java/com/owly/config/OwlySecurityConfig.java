package com.owly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.owly.persistence.dao.AlumnoDao;
import com.owly.persistence.dao.TutorDao;
import com.owly.service.OwlyUserService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages={"com.owly.config", "com.owly.persistence"})
public class OwlySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AlumnoDao alumnoDao;
	
	@Autowired
	TutorDao tutorDao;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		OwlyUserService service=new OwlyUserService();
		service.setAlumnoDao(alumnoDao);
		service.setTutorDao(tutorDao);
		auth.userDetailsService(service);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").successHandler(getHandler()).and()
	    .logout().logoutSuccessUrl("/login?logout").and().authorizeRequests()
		.antMatchers("/registro/**").permitAll()
	    .antMatchers("/alumno/**").hasAnyRole("ALUMNO")
		.antMatchers("/tutor/**").hasAnyRole("TUTOR")
		.anyRequest().permitAll();
	}
	
	@Bean
	public AuthenticationSuccessHandler getHandler(){
		AuthenticationSuccessHandler authenticationHandler=new OwlyAuthenticationSuccesHandler();
		return authenticationHandler;
	}
}
