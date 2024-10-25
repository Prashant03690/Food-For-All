package com.backend.foodforall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.foodforall.entities.Donor;
import com.backend.foodforall.entities.Donorfood;
import com.backend.foodforall.service.DonorfoodService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DonorfoodController {

	@Autowired
	DonorfoodService donorfoodService;
	
	@GetMapping("/getAllDonorfood")
	public List <Donorfood> getAllDonor()
	{
		return donorfoodService.getAllDonorFood();
	}
	
	@PostMapping("/postDonorfood")
	public Donorfood postDonorFood(@RequestBody Donorfood d)
	{
		return donorfoodService.postDf(d);
	}
	
	
}
