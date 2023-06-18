package com.masai.service;

import java.time.LocalDate;

public class Transaction {
	private String userName;
	private String email;
	private String destination;
	private double price;
	private double total;
	private LocalDate dt;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDate getDt() {
		return dt;
	}
	
	public void setDt(LocalDate dt) {
		this.dt = dt;
	}
	
	public Transaction(String userName, String email, String destination, double price, double total, LocalDate dt) {
		super();
		this.userName = userName;
		this.email = email;
		this.destination = destination;
		this.price = price;
		this.total = total;
		this.dt = dt;
	}
	
	@Override
	public String toString() {
		return "Transaction [userName=" + userName + ", email=" + email + ", destination=" + destination + ", price="
				+ price + ", total=" + total + ", dt=" + dt + "]";
	}
	
	
	
	
}
