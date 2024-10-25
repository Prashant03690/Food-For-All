package com.backend.foodforall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.foodforall.entities.CheckLogin;
import com.backend.foodforall.entities.Companies;
import com.backend.foodforall.entities.Ngo;
import com.backend.foodforall.service.NgoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NgoController {
	
	@Autowired
	NgoService ngoService;

	@GetMapping("/getAllNgo")
	public List<Ngo> getAllNgo()
	{
		return ngoService.getAllNgo();
	}
	
	@PostMapping("/ngoSignIn")
	public Ngo signIn(@RequestBody Ngo n)
	{
		return ngoService.signIn(n);
	}
	
	@GetMapping("/getNgo")
	public Ngo getNgo(@RequestParam("id") int ngoid)
	{
		return ngoService.getNgo(ngoid);
	}
	
	
	@DeleteMapping("deleteNgo/{ngoid}")
	public String deleteNgo(@PathVariable int ngoid)
	{
	    ngoService.deleteNgo(ngoid);
	    return "Ngo Deleted";
	}
	
	@PostMapping("/checkNgoLogin")
	public Ngo checkLogin(@RequestBody CheckLogin lc)
	{
		return ngoService.getLogin(lc.getEmail(), lc.getPassword());
	}
}
