package com.backend.foodforall.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="donor")
public class Donor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	
	@Column
	private String rname;
	
	@Column
	private String raddr;
	
	@Column
	private String remail;
	
	@Column
	private String rpassword;
	
	@Column
	private String rphone;
	
	@JsonIgnoreProperties("donor")
	@ManyToOne
	@JoinColumn(name="citypincode")
	City city;

	public Donor(String rname, String raddr, String remail, String rpassword, String rphone, City city) {
		super();
		this.rname = rname;
		this.raddr = raddr;
		this.remail = remail;
		this.rpassword = rpassword;
		this.rphone = rphone;
		this.city = city;
	}
	
	public Donor()
	{
		super();
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRaddr() {
		return raddr;
	}

	public void setRaddr(String raddr) {
		this.raddr = raddr;
	}

	public String getRemail() {
		return remail;
	}

	public void setRemail(String remail) {
		this.remail = remail;
	}

	public String getRpassword() {
		return rpassword;
	}

	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}

	public String getRphone() {
		return rphone;
	}

	public void setRphone(String rphone) {
		this.rphone = rphone;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	

}
