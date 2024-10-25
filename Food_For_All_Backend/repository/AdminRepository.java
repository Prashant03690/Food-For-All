package com.backend.foodforall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Admin;
import com.backend.foodforall.entities.Companies;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("select a from Admin a where aid=:aid")
	public Optional<Admin> getAdmin(int aid);
	
	@Query("select a from Admin a where aemail=:aemail and apassword=:apassword")
	public Optional<Admin> getLogin(String aemail,String apassword);
	
}
