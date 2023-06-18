package com.masai.service;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Destination implements Serializable {
	public static List<String> des = new ArrayList();
	private int id;
	private String date;
	private String time;
	
	
	
	public Destination(int id, String date, String time) {
		
		this.id = id;
		this.date = date;
		this.time = time;
	}

	static {
		des.add("Paris");
		des.add("London");
		des.add("New York");
		des.add("Chennai");
		des.add("Bangalore");
	}
	
	public static void viewDestinations() {
		for(String a : des) {
			System.out.println(a);
		}
	}
	
	
	@Override
	public String toString() {
		return "Destination [id=" + id + ", date=" + date + ", time=" + time + "]";
	}


	

	public static void figths(Map<String, List<Destination>> pro) {
		// TODO Auto-generated method stub
		for(String a : pro.keySet()) {
			System.out.println(a+" "+pro.get(a.toString()));
		}
		
	}
	
	
	
	
	
	

}
