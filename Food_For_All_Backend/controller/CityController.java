package com.backend.foodforall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.foodforall.entities.City;
import com.backend.foodforall.service.CityService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@GetMapping("/getAllCity")
	public List<City> getAllCity()
	{
		return cityService.getAllCity();
	}
	
	@GetMapping("/getCity")
	public City getCity(@RequestParam("pincode") String citypincode)
	{
		return cityService.getCity(citypincode);
	}

	
}
