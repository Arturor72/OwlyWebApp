package com.owly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public String getLogin(){
		return "Login";	
	}
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String getLoginPost(){
		return "init";	
	}
}
