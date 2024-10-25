package com.backend.foodforall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.backend.foodforall.entities.Request;
import com.backend.foodforall.repository.RequestRepository;

@Service
public class RequestService {
	
	@Autowired
	RequestRepository requestRepository;
	
	public List<Request> getAllRequest()
	{
		return requestRepository.findAll();
	}
	
	public Request sendRequest(Request r)
	{
		return requestRepository.save(r);
		
	}
	
	public Request getRequestById(int reqid)
	{
		return requestRepository.findById(reqid).get();
	}
	
	public void deleteRequest(int reqid)
	{
	    requestRepository.deleteById(reqid);
	}
	
	public List<Request> getRequest(int ngoid)
	{
		return requestRepository.getRequestByNgo(ngoid);
	}
}
