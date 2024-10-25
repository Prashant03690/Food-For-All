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
@Table(name="Ngo")
public class Ngo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ngoid;
	
	@Column
	private String ngoname;
	
	@Column
	private String ngophone;
	
	@Column
	private String ngoemail;
	
	@Column
	private String ngoaddress;

	@Column
	private String ngopassword;
	
	@JsonIgnoreProperties("Ngo")
	@ManyToOne
	@JoinColumn(name="citypincode")
	City city;
	
	public Ngo(String ngoname, String ngophone, String ngoemail, String ngopassword, String ngoaddress, City city) {
		super();
		this.ngoname = ngoname;
		this.ngophone = ngophone;
		this.ngoemail = ngoemail;
		this.ngopassword = ngopassword;
		this.ngoaddress = ngoaddress;
		this.city = city;
	}
	
	public Ngo() {
		
	}

	public int getNgoid() {
		return ngoid;
	}

	public void setNgoid(int ngoid) {
		this.ngoid = ngoid;
	}

	public String getNgoname() {
		return ngoname;
	}

	public void setNgoname(String ngoname) {
		this.ngoname = ngoname;
	}

	public String getNgophone() {
		return ngophone;
	}

	public void setNgophone(String ngophone) {
		this.ngophone = ngophone;
	}

	public String getNgoemail() {
		return ngoemail;
	}

	public void setNgoemail(String ngoemail) {
		this.ngoemail = ngoemail;
	}

	public String getNgoaddress() {
		return ngoaddress;
	}

	public void setNgoaddress(String ngoaddress) {
		this.ngoaddress = ngoaddress;
	}

	public String getNgopassword() {
		return ngopassword;
	}

	public void setNgopassword(String ngopassword) {
		this.ngopassword = ngopassword;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}


	
	
	

}
