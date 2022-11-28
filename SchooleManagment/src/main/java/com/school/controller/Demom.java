package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Demom {

	
	@GetMapping("/index")
	public String Home() {
		return "index";
	}
	
}
