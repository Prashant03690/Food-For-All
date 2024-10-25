package com.backend.foodforall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.foodforall.entities.Foodproduct;
import com.backend.foodforall.entities.Request;
import com.backend.foodforall.repository.RequestRepository;
import com.backend.foodforall.service.RequestService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RequestController {
	
	@Autowired
	RequestService requestService;
	
	@Autowired
	RequestRepository requestRepository;
	
	@GetMapping("/getAllRequest")
	public List<Request> getAllRequest()
	{
		return requestService.getAllRequest();
	}
	
	@PostMapping("/sendRequest")
	public Request sendRequest(@RequestBody Request r)
	{
		return requestService.sendRequest(r);
	}
	
	@GetMapping("/getRequest/{id}")
	public Request getCustomer(@PathVariable("id") int ngoid)
	{
		return requestService.getRequestById(ngoid);
	}
	
	@PutMapping("/updateRequest/{ngoid}")
	public Request updateRequest(@RequestBody Request newr, @PathVariable int ngoid)
	{
		return requestRepository.findById(ngoid)
				.map(Request -> {
					Request.setDonor(newr.getDonor());
					Request.setNgo(newr.getNgo());
					return requestRepository.save(newr);
					}).orElseThrow(null);
	}
	
	@DeleteMapping("deleteRequest/{reqid}")
	public String deleteRequest(@PathVariable int reqid)
	{
	    requestService.deleteRequest(reqid);
	    return "Request Removed";
	}
	
	@GetMapping("/getRequestByNgo/{ngoid}")
	public List<Request> getByNgo(@PathVariable("ngoid") int ngoid)
	{
		return requestService.getRequest(ngoid);
	}

}
