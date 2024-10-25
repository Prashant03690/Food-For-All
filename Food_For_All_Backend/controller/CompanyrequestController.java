package com.backend.foodforall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.foodforall.entities.Companyrequest;
import com.backend.foodforall.entities.Request;
import com.backend.foodforall.repository.CompanyrequestRepository;
import com.backend.foodforall.repository.RequestRepository;
import com.backend.foodforall.service.CompanyrequestService;
import com.backend.foodforall.service.RequestService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CompanyrequestController {
	
	@Autowired
	CompanyrequestService companyrequestService;
	
	@Autowired
	CompanyrequestRepository companyrequestRepository;
	
	@GetMapping("/getAllCompanyrequest")
	public List<Companyrequest> getAllRequest()
	{
		return companyrequestService.getAllRequest();
	}
	
	@PostMapping("/sendCompanyrequest")
	public Companyrequest sendRequest(@RequestBody Companyrequest r)
	{
		return companyrequestService.sendRequest(r);
	}
	
	@GetMapping("/getCompanyrequest/{id}")
	public Companyrequest getCustomer(@PathVariable("id") int reqid)
	{
		return companyrequestService.getRequestById(reqid);
	}
	
	@GetMapping("/getRequestByCompany/{coid}")
	public List<Companyrequest> getByNgo(@PathVariable("coid") int coid)
	{
		return companyrequestService.getcrbycompany(coid);
	}

	
	@PutMapping("/updateCompanyrequest/{reqid}")
	public Companyrequest updateRequest(@RequestBody Companyrequest newr, @PathVariable int reqid)
	{
		return companyrequestRepository.findById(reqid)
				.map(Companyrequest -> {
					Companyrequest.setDonor(newr.getDonor());
					Companyrequest.setCompanies(newr.getCompanies());
					return companyrequestRepository.save(newr);
					}).orElseThrow(null);
	}
	
	@DeleteMapping("deleteCompanyRequest/{reqid}")
	public String deleteRequest(@PathVariable int reqid)
	{
	    companyrequestService.deleteRequest(reqid);
	    return "Request Removed";
	}

}
