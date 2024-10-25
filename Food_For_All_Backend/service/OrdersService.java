package com.backend.foodforall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Orders;
import com.backend.foodforall.repository.OrdersRepository;

@Service
public class OrdersService {
	
	@Autowired
	OrdersRepository ordersRepository;
	
	public List<Orders> getAllOrders()
	{
		return ordersRepository.findAll();
	}
	
	public Orders postOrders(Orders o)
	{
		return ordersRepository.save(o);
	}

}
