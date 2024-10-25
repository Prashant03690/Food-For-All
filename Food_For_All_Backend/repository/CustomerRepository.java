package com.backend.foodforall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Companies;
import com.backend.foodforall.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where cid=:cid")
	public Optional<Customer> getCustomer(int cid);
	
	@Query("select c from Customer c where cemail=:cemail and cpassword=:cpassword")
	public Optional<Customer> getLogin(String cemail,String cpassword);
}
