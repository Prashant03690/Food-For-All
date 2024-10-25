package com.backend.foodforall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperimentController {
	
	@GetMapping("/namaskar")
	public String hello() {
		System.out.println("Prashant Got");
		return "prashant";
	}


}
