package com.backend.foodforall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Cart;
import com.backend.foodforall.entities.Foodproduct;
import com.backend.foodforall.repository.CartRepository;

@Service
public class CartService{

	@Autowired
	CartRepository cartRepository;
	
	public Cart getCartById(int caid)
	{
		return cartRepository.findById(caid).get();
	}

	public List<Cart> getAllCart() 
	{
		return cartRepository.findAll();
	}
	
	public Cart addToCart(Cart c)
	{
		return cartRepository.save(c);
	}
	
	public List<Cart> getByCustomer(int cid)
	{
		return cartRepository.getByCustomer(cid);
	}
	
	public void deleteCart(int caid)
	{
	    cartRepository.deleteById(caid);
	}
}
