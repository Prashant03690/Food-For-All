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
@Table(name="companies")
public class Companies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coid;
	
	@Column
	private String coname;	

	@Column
	private String coaddress;
	
	@Column
	private String cophone;
	
	@Column
	private String coemail;
	
	@Column
	private String copassword;
	
	@JsonIgnoreProperties("companies")
	@ManyToOne
	@JoinColumn(name="citypincode")
	City city;
	
	
	public int getCoid() {
		return coid;
	}

	public void setCoid(int coid) {
		this.coid = coid;
	}

	public String getConame() {
		return coname;
	}

	public Companies(String coname, String coaddress, String cophone, String coemail, String copassword,
			City city) {
		super();
		this.coname = coname;
		this.coaddress = coaddress;
		this.cophone = cophone;
		this.coemail = coemail;
		this.copassword = copassword;
		this.city = city;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Companies()
	{
		super();
	}
	
	public String getCoName() {
		return coname;
	}

	public void setConame(String coname) {
		this.coname = coname;
	}

	public String getCoaddress() {
		return coaddress;
	}

	public void setCoaddress(String coaddress) {
		this.coaddress = coaddress;
	}

	public String getCophone() {
		return cophone;
	}

	public void setCophone(String cophone) {
		this.cophone = cophone;
	}

	public String getCoemail() {
		return coemail;
	}

	public void setCoemail(String coemail) {
		this.coemail = coemail;
	}

	public String getCopassword() {
		return copassword;
	}

	public void setCopassword(String copassword) {
		this.copassword = copassword;
	}


	

	

}
