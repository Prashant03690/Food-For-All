package com.backend.foodforall.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.backend.foodforall.entities.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

	@Query("select r from Request r where reqid=:reqid")
	Optional<Request> getRequest(int reqid);
	
	@Query("select r from Request r where reqid=:reqid")
	Optional<Request> getRequestById(int reqid);
	
	@Query("select r from Request r where ngoid=:ngoid")
	List<Request> getRequestByNgo(int ngoid);
	
	
	
	
	
}
