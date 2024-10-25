package com.backend.foodforall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {

	@Query("select r from Donor r where rid=:rid")
	public Optional<Donor> getDonor(int rid);
	
	@Query("select r from Donor r where remail=:remail and rpassword=:rpassword")
	public Optional<Donor> getLogin(String remail, String rpassword);
}
