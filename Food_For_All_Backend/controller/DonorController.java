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
import com.backend.foodforall.entities.Donor;
import com.backend.foodforall.service.DonorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DonorController {

	@Autowired
	DonorService donorService;
	
	@GetMapping("/getAllDonor")
	public List<Donor> getAllDonor()
	{
		return donorService.getAllDonor();
	}
	
	@PostMapping("donorSignIn")
	public Donor SignIn(@RequestBody Donor d)
	{
		return donorService.signIn(d);
	}
	
	@GetMapping("/getDonor")
	public Donor getDonor(@RequestParam("id") int rid)
	{
		return donorService.getDonor(rid);
	}
	
	
	
	@DeleteMapping("deleteDonor/{rid}")
	public String deleteDonor(@PathVariable int rid)
	{
	    donorService.deleteDonor(rid);
	    return "Donor Deleted";
	}
	
	@PostMapping("/checkDonorLogin")
	public Donor checkLogin(@RequestBody CheckLogin lc)
	{
		return donorService.getLogin(lc.getEmail(), lc.getPassword());
	}
	
}
