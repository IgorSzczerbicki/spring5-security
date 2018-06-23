package com.nauka.spring5.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/systems")
	public String systems() {
		return "systems";
	}
	
	@GetMapping("/leaders")
	public String leaders() {
		return "leaders";
	}
}