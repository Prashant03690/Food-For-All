package com.backend.foodforall.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="companyrequest")
public class Companyrequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reqid;
	
	@JsonIgnoreProperties("companyrequest")
	@ManyToOne
	@JoinColumn(name="rid")
	Donor donor;
	
	@JsonIgnoreProperties("companyrequest")
	@ManyToOne
	@JoinColumn(name="coid")
	Companies companies;
	
	public Companyrequest()
	{
		super();
	}

	public Companyrequest(Donor donor, Companies companies) {
		super();
		this.donor = donor;
		this.companies = companies;
	}

	public int getReqid() {
		return reqid;
	}

	public void setReqid(int reqid) {
		this.reqid = reqid;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Companies getCompanies() {
		return companies;
	}

	public void setCompanies(Companies companies) {
		this.companies = companies;
	}
	
	
	
	
	

}
