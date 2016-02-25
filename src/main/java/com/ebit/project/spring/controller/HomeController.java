package com.ebit.project.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome(Model model){
		return "home";
	}
	
	@RequestMapping("/login")
	public String showLogin(Model model){
		return "login";
	}
	
	@RequestMapping("/hello")
	public String showHelloPage(Model model){
		return "hello";
	}
}
