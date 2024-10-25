package com.backend.foodforall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.foodforall.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	@Query("select o from Orders o where oid=:oid")
	public Optional<Orders> getOrders(int oid);
}
