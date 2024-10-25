package com.backend.foodforall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Companies;
import com.backend.foodforall.entities.Donor;
import com.backend.foodforall.repository.DonorRepository;

@Service
public class DonorService {

	@Autowired
	DonorRepository donorRepository;
	
	public List<Donor> getAllDonor()
	{
		return donorRepository.findAll();
	}
	
	public Donor signIn(Donor d)
	{
		return donorRepository.save(d);
	}
	
	public Donor getDonor(int rid)
	{
		return donorRepository.findById(rid).get();
	}
	
	public void deleteDonor(int rid)
	{
	    donorRepository.deleteById(rid);
	}
	
	public Donor getLogin(String remail, String rpassword)
	{
		Donor d;
		Optional<Donor> donor = donorRepository.getLogin(remail, rpassword);
		try {
			d = donor.get();
		}catch(Exception e)
		{
			d = null;
		}
		return d;
		
	}
}
