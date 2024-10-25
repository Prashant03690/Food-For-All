package com.backend.foodforall.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int caid;
	
	@JsonIgnoreProperties("cart")
	@ManyToOne
	@JoinColumn(name="cid")
	Customer customer;
	
	@JsonIgnoreProperties("cart")
	@ManyToOne
	@JoinColumn(name="fpid")
	Foodproduct foodproduct;
	
	public Cart()
	{
		super();
	}

	public Cart(Customer customer, Foodproduct foodproduct) {
		super();
		this.customer = customer;
		this.foodproduct = foodproduct;
		
	}

	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Foodproduct getFoodproduct() {
		return foodproduct;
	}

	public void setFoodproduct(Foodproduct foodproduct) {
		this.foodproduct = foodproduct;
	}

	
	
	

}
