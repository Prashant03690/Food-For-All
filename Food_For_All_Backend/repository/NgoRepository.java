package com.backend.foodforall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Ngo;

@Repository
public interface NgoRepository extends JpaRepository<Ngo, Integer> {

	@Query("select n from Ngo n where Ngoid=:Ngoid")
	public Optional<Ngo> getNgo(int Ngoid);
	
	@Query("select n from Ngo n where ngoemail=:ngoemail and ngopassword=:ngopassword")
	public Optional<Ngo> getLogin(String ngoemail, String ngopassword);
}
