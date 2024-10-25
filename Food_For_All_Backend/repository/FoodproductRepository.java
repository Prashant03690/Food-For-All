package com.backend.foodforall.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Foodproduct;

@Repository
public interface FoodproductRepository extends JpaRepository<Foodproduct, Integer> {

	@Query("select fp from Foodproduct fp where fpid=:fpid")
	public Optional<Foodproduct> getFoodproduct(int fpid);
	
	@Query("select fp from Foodproduct fp where coid=:coid")
	public List<Foodproduct> getByCompany(int coid);
	
	
}
