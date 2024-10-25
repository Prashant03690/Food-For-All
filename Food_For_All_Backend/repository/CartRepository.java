package com.backend.foodforall.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Cart;
import com.backend.foodforall.entities.Foodproduct;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	@Query("select c from Cart c where caid=:caid")
	public Optional<Cart> getCart(int caid);
	
	@Query("select c from Cart c where cid=:cid")
	public List<Cart> getByCustomer(int cid);
}
