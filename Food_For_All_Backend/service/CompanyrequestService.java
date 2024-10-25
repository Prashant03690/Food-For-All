package com.backend.foodforall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Companyrequest;
import com.backend.foodforall.entities.Request;
import com.backend.foodforall.repository.CompanyrequestRepository;

@Service
public class CompanyrequestService {
	
	@Autowired
	CompanyrequestRepository companyrequestRepository;
	
	public List<Companyrequest> getAllRequest()
	{
		return companyrequestRepository.findAll();
	}
	
	public Companyrequest sendRequest(Companyrequest r)
	{
		return companyrequestRepository.save(r);
		
	}
	
	public Companyrequest getRequestById(int reqid)
	{
		return companyrequestRepository.findById(reqid).get();
	}
	
	public List<Companyrequest> getcrbycompany(int coid)
	{
		return companyrequestRepository.getcrbycompany(coid);
	}
	
	public void deleteRequest(int reqid)
	{
	    companyrequestRepository.deleteById(reqid);
	}
	
	
}
