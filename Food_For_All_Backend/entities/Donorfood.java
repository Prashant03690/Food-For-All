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
@Table(name="donorfood")
public class Donorfood {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	
	@Column
	private String fqty;
	
	@JsonIgnoreProperties("donorfood")
	@ManyToOne
	@JoinColumn(name="rid")
	Donor donor;
	
	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Donorfood()
	{
		super();
	}

	public Donorfood(String fqty, Donor donor) {
		super();
		this.fqty = fqty;
		this.donor = donor;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFqty() {
		return fqty;
	}

	public void setFqty(String fqty) {
		this.fqty = fqty;
	}
	
	
	
	

}
