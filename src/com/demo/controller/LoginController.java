package com.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.LoginForm;

@Controller("login")
public class LoginController {
	@RequestMapping(method=RequestMethod.GET)
	public String loadLoginForm(Map model) {
		
		LoginForm log = new LoginForm();
		model.put("loginForm", log);
		
		return "login";
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public String processLogin(LoginForm log, BindingResult result, Map model) {
		if(result.hasErrors()) {
			ModelAndView modelView = new ModelAndView("loginForm");
			return "login";
		}
		if(log.getUserName().equals("madhu"))
			return "dashboard";
		return "error";
	}
}
