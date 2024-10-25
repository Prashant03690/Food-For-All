package com.backend.foodforall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Foodproduct;
import com.backend.foodforall.repository.FoodproductRepository;

@Service
public class FoodproductService {

	@Autowired
	FoodproductRepository foodproductRepository;
	
	
	
	public List<Foodproduct> getAllFoodproduct()
	{
		return foodproductRepository.findAll();
	}
	
	public Foodproduct postFP(Foodproduct p)
	{
		return foodproductRepository.save(p);
	}
	
	public Foodproduct getFoodproduct(int fpid)
	{
		return foodproductRepository.findById(fpid).get();	
	}
	
	public void deleteFoodproduct(int fpid)
	{
	    foodproductRepository.deleteById(fpid);
	}
	
	public List<Foodproduct> getByCompany(int coid)
	{
		return foodproductRepository.getByCompany(coid);
	}
	
}
