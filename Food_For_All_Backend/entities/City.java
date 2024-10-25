package com.backend.foodforall.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	
	@Id
	private String citypincode;
	
	@Column
	private String cityname;

	public City(String citypincode, String cityname) {
		super();
		this.citypincode = citypincode;
		this.cityname = cityname;
	}

	public City()
	{
		
	}

	public String getCitypincode() {
		return citypincode;
	}

	public void setCitypincode(String citypincode) {
		this.citypincode = citypincode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	
}
