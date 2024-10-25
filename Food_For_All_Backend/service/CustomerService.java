package com.backend.foodforall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Companies;
import com.backend.foodforall.entities.Customer;
import com.backend.foodforall.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomer()
	{
		return customerRepository.findAll();
	}
	
	public Customer signIn(Customer c)
	{
		return customerRepository.save(c);
	}
	
	public Customer getCustomer(int cid)
	{
		return customerRepository.findById(cid).get();
	}
	
	public void deleteCustomer(int cid)
	{
	    customerRepository.deleteById(cid);
	}
	
	public Customer getLogin(String cemail, String cpassword)
	{
		Customer c;
		Optional<Customer> cus = customerRepository.getLogin(cemail, cpassword);
		try {
			c = cus.get();
		}catch(Exception e)
		{
			c = null;
		}
		return c;
	}
}
