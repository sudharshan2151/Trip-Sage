package com.masai.service;
import java.io.Serializable;

public class User implements Serializable{
	
	private final String userName;
	private final String password;
	private String address;
	private String email;
	
	

	public User( String userName, String password, String address, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.email = email;
	}

	

	public String getUserName() {
		return userName;
	}

	

	public String getPassword() {
		return password;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [ userName=" + userName + ", password=" + password + ", address=" + address
				+ ", email=" + email + "]";
	}
	
	
}
