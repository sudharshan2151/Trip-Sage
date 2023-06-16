package com.masai.service;
import  java.io.Serializable;
public class TravalAgent extends User implements Serializable{
	private String qualification;

	public TravalAgent(String qualification, String username, String password, String address, String email) {
		super(username, password, address, email);
		this.qualification = qualification;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	
}
