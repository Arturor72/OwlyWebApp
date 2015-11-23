package com.owly.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AdviceController {
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView exception(Exception e, WebRequest request){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("errorMessage", e.getMessage());
		modelAndView.setViewName("Error");
		return modelAndView;
	}		

}
