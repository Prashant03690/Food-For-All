package com.backend.foodforall.entities;

public class CheckLogin {
	
	private String email;
	
	private String password;

	public CheckLogin()
	{
		super();
	}
	
	public CheckLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
