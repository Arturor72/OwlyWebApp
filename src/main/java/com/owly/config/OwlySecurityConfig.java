package com.owly.config;

import org.hibernate.annotations.BatchSize;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.owly.persistence.dao.AlumnoDao;
import com.owly.service.OwlyUserService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages={"com.owly.config", "com.owly.persistence"})
public class OwlySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AlumnoDao alumnoDao;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
//				.withUser("admin").password("password").roles("ADMIN");
		
		auth.userDetailsService(new OwlyUserService(alumnoDao));
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").and()
	    .logout().logoutSuccessUrl("/login?logout").and().authorizeRequests()
//		.antMatchers("/ente").authenticated()
		.antMatchers("/alumno/**").hasAnyRole("ALUMNO")
		.antMatchers("/tutor/**").hasAnyRole("TUTOR")
		.anyRequest().permitAll();
	}
	
	
}
