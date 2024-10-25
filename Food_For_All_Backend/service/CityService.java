package com.backend.foodforall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.City;
import com.backend.foodforall.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepository;
	
	public List<City> getAllCity()
	{
		return cityRepository.findAll();
	}
	
	public City getCity(String citypincode)
	{
		return cityRepository.findById(citypincode).get();
	}
}
