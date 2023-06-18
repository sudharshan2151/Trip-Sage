package com.masai.service;
import java.io.Serializable;

public class Bookings implements Serializable{
	int price;
	String destination;
	String transport;
	int noOfPassenger;
	String email;
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Bookings(int id,String destination, String transport, int noOfPassenger, String email) {
		//super();
		this.price = id;
		this.destination = destination;
		this.transport = transport;
		this.noOfPassenger = noOfPassenger;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Bookings [destination=" + destination + ", transport=" + transport + ", noOfPassenger=" + noOfPassenger
				+ ", email=" + email + "]";
	}
	
	
	
}
