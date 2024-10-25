package com.backend.foodforall.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Companies;

@Repository
public interface CompaniesRepository extends JpaRepository<Companies, Integer> {

	@Query("select co from Companies co where coid=:coid")
	public Optional<Companies> getCompanies(int coid);
	
	@Query("select co from Companies co where coemail=:coemail and copassword=:copassword")
	public Optional<Companies> getLogin(String coemail,String copassword);
}
