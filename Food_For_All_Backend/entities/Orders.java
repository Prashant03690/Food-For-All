package com.backend.foodforall.entities;

import java.util.Date;

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
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	
	@Column
	private Date orderdate;
	
	@Column
	private String orderstatus;
	
	@JsonIgnoreProperties("orders")
	@ManyToOne
	@JoinColumn(name="cid")
	Customer customer;
	
	
	
	
}
