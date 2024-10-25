package com.backend.foodforall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Companies;
import com.backend.foodforall.entities.Ngo;
import com.backend.foodforall.repository.NgoRepository;

@Service
public class NgoService {
	
	@Autowired
	NgoRepository ngoRepository;
	
	public List<Ngo> getAllNgo()
	{
		return ngoRepository.findAll();
	}
	
	public Ngo signIn(Ngo n)
	{
		return ngoRepository.save(n);
	}
	
	public Ngo getNgo(int ngoid)
	{
		return ngoRepository.findById(ngoid).get();
	}
	
	public void deleteNgo(int ngoid)
	{
	    ngoRepository.deleteById(ngoid);
	}
	
	public Ngo getLogin(String ngoemail, String ngopassword)
	{
		Ngo n;
		Optional<Ngo> ngo = ngoRepository.getLogin(ngoemail, ngopassword);
		try {
			n = ngo.get();
		}catch(Exception e)
		{
			n = null;
		}
		return n;
		
	}

}
