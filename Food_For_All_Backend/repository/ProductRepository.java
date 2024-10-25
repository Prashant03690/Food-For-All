package com.backend.foodforall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	@Query("select p from Product p where pid=:pid")
	public Optional<Product> getProduct(int pid);
}
