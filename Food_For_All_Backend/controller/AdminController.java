package com.backend.foodforall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.foodforall.entities.Admin;
import com.backend.foodforall.entities.CheckLogin;
import com.backend.foodforall.entities.Companies;
import com.backend.foodforall.service.AdminService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/getAllAdmin")
	public List<Admin>getAllAdmin()
	{
		return adminService.getAllAdmin();
	}
	
	@PostMapping("/adminSignIn")
	public Admin signIn(@RequestBody Admin a)
	{
		return adminService.signIn(a);
	}
	
	@GetMapping("/getAdmin")
	public Admin getAdmin(@RequestParam("id")int aid)
	{
		return adminService.getAdmin(aid);
	}
	
	@PostMapping("/checkAdminLogin")
	public Admin checkLogin(@RequestBody CheckLogin lc)
	{
		return adminService.getLogin(lc.getEmail(), lc.getPassword());
	}
	

}
