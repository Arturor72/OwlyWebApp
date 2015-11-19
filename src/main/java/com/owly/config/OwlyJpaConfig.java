package com.owly.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.owly.constants.OwlyConstants;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.owly.persistence"})
@PropertySource({"classpath:jdbc.properties"})
public class OwlyJpaConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean ent=new LocalContainerEntityManagerFactoryBean();
		ent.setDataSource(dataSource());
		ent.setPackagesToScan(new String[] { "com.owly.persistence.model" });
		JpaVendorAdapter vendor=new HibernateJpaVendorAdapter();
		ent.setJpaVendorAdapter(vendor);
		ent.setJpaProperties(additionalProperties());
		return ent;
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(OwlyConstants.DATABASE_DRIVER_PROPERTIE));
		dataSource.setUrl(env.getProperty(OwlyConstants.DATABASE_URL_PROPERTIE));
		dataSource.setUsername(env.getProperty(OwlyConstants.DATABASE_USER_PROPERTIE));
		dataSource.setPassword(env.getProperty(OwlyConstants.DATABASE_PASSWORD_PROPERTIE));
		return dataSource;
	}
	
	@Bean
	   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	 
	      return transactionManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty(OwlyConstants.HIBERNATE_AUTO_PROPERTIE, env.getProperty(OwlyConstants.HIBERNATE_AUTO_PROPERTIE));
	      properties.setProperty(OwlyConstants.HIBERNATE_DIALECT_PROPERTIE, env.getProperty(OwlyConstants.HIBERNATE_DIALECT_PROPERTIE));
	      properties.setProperty(OwlyConstants.HIBERNATE_SHOW_SQL_PROPERTIE, env.getProperty(OwlyConstants.HIBERNATE_SHOW_SQL_PROPERTIE));
	      return properties;
	   }

}
