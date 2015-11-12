package com.owly.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class OwlySecurityInitializer extends AbstractSecurityWebApplicationInitializer{
	
public OwlySecurityInitializer() {
   super(OwlySecurityConfig.class);
}

}
