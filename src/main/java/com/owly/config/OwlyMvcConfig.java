package com.owly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.owly.constants.OwlyConstants;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.owly.config", "com.owly.controller"})
public class OwlyMvcConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix(OwlyConstants.RESOLVER_VIEW_PREFIX);
		resolver.setSuffix(OwlyConstants.RESOLVER_VIEW_SUFIX);
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
