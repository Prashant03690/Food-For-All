package com.backend.foodforall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Companies;
import com.backend.foodforall.repository.CompaniesRepository;

@Service
public class CompaniesService {

	@Autowired
	CompaniesRepository companiesRepository;
	
	public Companies signIn(Companies c)
	{
		return companiesRepository.save(c);
	}
	
	public List<Companies> getAllCompanies()
	{
		return companiesRepository.findAll();
	}
	
	public Companies getCompanies(int coid)
	{
		return companiesRepository.findById(coid).get();
	}
	
	public void deleteCompanies(int coid)
	{
	    companiesRepository.deleteById(coid);
	}
	
	public Companies getLogin(String coemail, String copassword)
	{
		Companies c;
		Optional<Companies> com = companiesRepository.getLogin(coemail, copassword);
		try {
			c = com.get();
		}catch(Exception e)
		{
			c = null;
		}
		return c;
		
	}
	

	
	
	
	
}
