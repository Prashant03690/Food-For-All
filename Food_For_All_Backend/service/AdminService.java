package com.backend.foodforall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Admin;
import com.backend.foodforall.entities.Companies;
import com.backend.foodforall.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	public List<Admin> getAllAdmin()
	{
		return adminRepository.findAll();
	}
	
	public Admin signIn(Admin a)
	{
		return adminRepository.save(a);
	}
	
	public Admin getAdmin(int aid)
	{
		return adminRepository.findById(aid).get();
	}
	
	public Admin getLogin(String aemail, String apassword)
	{
		Admin a;
		Optional<Admin> adm = adminRepository.getLogin(aemail, apassword);
		try {
			a = adm.get();
		}catch(Exception e)
		{
			a = null;
		}
		return a;
		
	}
	
	
}
