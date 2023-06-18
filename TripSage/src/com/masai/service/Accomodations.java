package com.masai.service;

import java.io.Serializable;

public class Accomodations implements Serializable{
	String hotelName ;
	String  City;
	String  Area;
	int noOfRooms;
	
	public Accomodations(String hotelName, String city, String area, int noOfRooms) {
		super();
		this.hotelName = hotelName;
		City = city;
		Area = area;
		this.noOfRooms = noOfRooms;
	}
	
}
