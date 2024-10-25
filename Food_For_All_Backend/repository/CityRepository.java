package com.backend.foodforall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
	
	@Query("select c from City c where citypincode=:citypincode")
	public Optional<City> getCity(String citypincode);

}
