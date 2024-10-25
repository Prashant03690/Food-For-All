package com.backend.foodforall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Donorfood;

@Repository
public interface DonorfoodRepository extends JpaRepository<Donorfood, Integer> {

	@Query("select d from Donorfood d where fid=:fid")
	public Optional<Donorfood> getDonor(int fid);
}
