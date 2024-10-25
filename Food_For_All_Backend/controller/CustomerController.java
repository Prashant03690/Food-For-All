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
import com.backend.foodforall.entities.Customer;
import com.backend.foodforall.service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/customerSignIn")
	public Customer signIn(@RequestBody Customer c)
	{
		return customerService.signIn(c);
	}
	
	@GetMapping("/getCustomer")
	public Customer getCustomer(@RequestParam("id") int cid)
	{
		return customerService.getCustomer(cid);
	}
	
	
	@DeleteMapping("deleteCustomer/{cid}")
	public String deleteCustomer(@PathVariable int cid)
	{
	    customerService.deleteCustomer(cid);
	    return "Customer Deleted";
	}
	
	@PostMapping("/checkCustomerLogin")
	public Customer checkLogin(@RequestBody CheckLogin lc)
	{
		return customerService.getLogin(lc.getEmail(), lc.getPassword());
	}
}
