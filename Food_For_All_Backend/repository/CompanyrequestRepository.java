package com.backend.foodforall.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Companyrequest;
import com.backend.foodforall.entities.Request;

@Repository
public interface CompanyrequestRepository extends JpaRepository<Companyrequest, Integer> {
	
	@Query("select r from Companyrequest r where reqid=:reqid")
	Optional<Companyrequest> getCompanyrequest(int reqid);
	
	@Query("select r from Companyrequest r where coid=:coid")
	List<Companyrequest> getcrbycompany(int coid);

}
