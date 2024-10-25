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
@Table(name="request")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reqid;
	
	@JsonIgnoreProperties("request")
	@ManyToOne
	@JoinColumn(name="rid")
	Donor donor;
	
	@JsonIgnoreProperties("request")
	@ManyToOne
	@JoinColumn(name="ngoid")
	Ngo ngo;
	
	public Request()
	{
		super();
	}

	public Request(Donor donor, Ngo ngo) {
		super();
		this.donor = donor;
		this.ngo = ngo;
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

	public Ngo getNgo() {
		return ngo;
	}

	public void setNgo(Ngo ngo) {
		this.ngo = ngo;
	}
	
	
	
}
