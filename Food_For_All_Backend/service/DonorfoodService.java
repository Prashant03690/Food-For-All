package com.backend.foodforall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Donorfood;
import com.backend.foodforall.repository.DonorfoodRepository;

@Service
public class DonorfoodService {

	@Autowired
	DonorfoodRepository donorfoodRepository;
	
	
	public List<Donorfood> getAllDonorFood()
	{
		return donorfoodRepository.findAll();
	}
	
	public Donorfood postDf(Donorfood d)
	{
		return donorfoodRepository.save(d);
	}
}
