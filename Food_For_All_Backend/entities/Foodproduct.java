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
@Table(name="foodproduct")
public class Foodproduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fpid;
	
	@Column
	private String fpname;
	
	@Column
	private int fpprice;
	
	@Column
	private int fpqty;
	
	@JsonIgnoreProperties("foodproduct")
	@ManyToOne
	@JoinColumn(name= "coid" )
	private Companies companies;
	
	public Foodproduct()
	{
		super();
	}

	public Foodproduct(String fpname, int fpprice, int fpqty, Companies companies) {
		super();
		this.fpname = fpname;
		this.fpprice = fpprice;
		this.fpqty = fpqty;
		this.companies = companies;
	}

	public int getFpid() {
		return fpid;
	}

	public void setFpid(int fpid) {
		this.fpid = fpid;
	}

	public String getFpname() {
		return fpname;
	}

	public void setFpname(String fpname) {
		this.fpname = fpname;
	}

	public int getFpprice() {
		return fpprice;
	}

	public void setFpprice(int fpprice) {
		this.fpprice = fpprice;
	}

	public int getFpqty() {
		return fpqty;
	}

	public void setFpqty(int fpqty) {
		this.fpqty = fpqty;
	}

	public Companies getCompanies() {
		return companies;
	}

	public void setCompanies(Companies companies) {
		this.companies = companies;
	}
	
}

	