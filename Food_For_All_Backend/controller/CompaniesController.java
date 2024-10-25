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
import com.backend.foodforall.service.CompaniesService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CompaniesController {

	@Autowired
	CompaniesService companiesService;
	
	@GetMapping("/getAllCompanies")
	public List<Companies> getAllCompanies()
	{
		return companiesService.getAllCompanies();
	}
	
	@PostMapping("/companiesSignIn")
	public Companies signIn(@RequestBody Companies c)
	{
		return companiesService.signIn(c);
	}
	
	@GetMapping("/getCompanies")
	public Companies getCompanies(@RequestParam("id") int coid)
	{
		return companiesService.getCompanies(coid);
	}
	
	
	@DeleteMapping("deleteCompanies/{coid}")
	public String deleteCompanies(@PathVariable int coid)
	{
	    companiesService.deleteCompanies(coid);
	    return "Company Deleted";
	}
	
	@PostMapping("/checkCompanyLogin")
	public Companies checkLogin(@RequestBody CheckLogin lc)
	{
		return companiesService.getLogin(lc.getEmail(), lc.getPassword());
	}
	
	
}
