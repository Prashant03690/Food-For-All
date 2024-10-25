package com.backend.foodforall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.foodforall.entities.Cart;
import com.backend.foodforall.entities.Companies;
import com.backend.foodforall.entities.Foodproduct;
import com.backend.foodforall.service.CartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/getAllCart")
	public List<Cart> getAllCart()
	{
		return cartService.getAllCart();
	}
	
	@GetMapping("/getCart/{caid}")
	public Cart getCart(@PathVariable("caid") int caid)
	{
		return cartService.getCartById(caid);
	}
	
	@PostMapping("/addtoCart")
	public Cart addToCart(@RequestBody Cart c)
	{
		return cartService.addToCart(c);
	}
	
	@GetMapping("/getCartByCustomer/{cid}")
	public List<Cart> getByCustomer(@PathVariable("cid") int cid)
	{
		return cartService.getByCustomer(cid);
	}
	
	@DeleteMapping("/deleteCart/{caid}")
	public String deleteCart(@PathVariable("caid") int caid)
	{
	    cartService.deleteCart(caid);
	    return "Cart Item Deleted";
	}
	
	

}
