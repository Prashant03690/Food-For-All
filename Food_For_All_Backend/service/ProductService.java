package com.backend.foodforall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.foodforall.entities.Product;
import com.backend.foodforall.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
	
	public Product postProduct(Product p)
	{
		return productRepository.save(p);
	}
}

