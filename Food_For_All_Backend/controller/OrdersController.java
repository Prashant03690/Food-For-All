package com.backend.foodforall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.foodforall.entities.Orders;
import com.backend.foodforall.service.OrdersService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders()
	{
		return ordersService.getAllOrders();
	}
	
	@PostMapping("/postOrders")
	public Orders postOrders(@RequestBody Orders o)
	{
		return ordersService.postOrders(o);
	}

}
