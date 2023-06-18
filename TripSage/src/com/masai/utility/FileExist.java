package com.masai.utility;
import java.io.Serializable;
import com.masai.service.Bookings;
import java.util.Map;
import java.util.HashMap;
import com.masai.service.User;
import com.masai.service.TravalAgent;
import java.util.List;
import com.masai.service.Destination;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import com.masai.service.Destination;
import com.masai.utility.IDGeneration;


public class FileExist {
	
	public static List<String> destination()throws IOException{
		List<String> desr = Destination.des;
		try {
		
		FileOutputStream f = new FileOutputStream("destination.ser");
		ObjectOutputStream os = new ObjectOutputStream(f);
		os.writeObject(desr);
		return desr;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return desr;
	}
	
	
	public static Map<String,User> credentialsUser() throws Exception{
		Map<String,User> desr = new HashMap<String, User>();
		try {
		
		FileOutputStream f = new FileOutputStream("credentials.ser");
		ObjectOutputStream os = new ObjectOutputStream(f);
		
		os.writeObject(desr);
		return desr;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return desr;
	}
	
	public static Map<String,User> accomadations() throws Exception{
		Map<String,User> desr = new HashMap<String, User>();
		try {
		
		FileOutputStream f = new FileOutputStream("credentials.ser");
		ObjectOutputStream os = new ObjectOutputStream(f);
		
		os.writeObject(desr);
		return desr;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return desr;
	}
	
	public static Map<String, List<Destination>> flights() throws Exception{
	    Map<String, List<Destination>> destinationDates = new HashMap<>();
	    
	    
	    List<Destination> k = new ArrayList();
	    k.add(new Destination(IDGeneration.generateId(),"2023-07-10","10:00 AM - 12:00 PM"));
	    k.add(new Destination(IDGeneration.generateId(),"2023-07-15", "11:00 AM - 1:00 PM"));
	    k.add(new Destination(IDGeneration.generateId(),"2023-07-20", "9:00 AM - 11:00 AM"));
	 
	    destinationDates.put("Paris", k);
	    
	    
	    
	    
	    
	    List<Destination> london = new ArrayList();
	    london.add(new Destination(IDGeneration.generateId(),"2023-08-05", "9:30 AM - 11:30 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-08-10", "10:00 AM - 12:00 PM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-08-15", "11:30 AM - 1:30 PM"));
	    
	    
	    destinationDates.put("London", london);
	    
	    List<Destination> newYork = new ArrayList();
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-01", "8:00 AM - 10:00 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-07", "9:30 AM - 11:30 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-15", "10:00 AM - 12:00 PM"));
	    
	    destinationDates.put("NewYork", newYork);
	    
	    
	    List<Destination> bangalore = new ArrayList();
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-01", "8:30 AM - 10:30 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-07", "9:00 AM - 11:00 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-15", "10:30 AM - 12:30 PM"));
	    

	    List<Destination> chennai = new ArrayList();
	    chennai.add(new Destination(IDGeneration.generateId(),"2023-09-01", "9:00 AM - 11:00 AM"));
	    chennai.add(new Destination(IDGeneration.generateId(),"2023-09-07", "10:30 AM - 12:30 PM"));
	    chennai.add(new Destination(IDGeneration.generateId(),"2023-09-15", "11:00 AM - 1:00 PM"));
	    
	    
	    destinationDates.put("Chennai", chennai);
	    
	    destinationDates.put("Bangalore",bangalore);

	    try {
	        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("buses.ser"));
	        ois.writeObject(destinationDates);
	    } catch(Exception e) {
	        System.out.println(e.getMessage());
	    }

	    return destinationDates;
	}

    
    
    
	
	public static Map<String, List<Destination>> Buses() throws Exception{
	    Map<String, List<Destination>> destinationDates = new HashMap<>();
	    
	    
	    List<Destination> k = new ArrayList();
	    k.add(new Destination(IDGeneration.generateId(),"2023-07-10","10:00 AM - 12:00 PM"));
	    k.add(new Destination(IDGeneration.generateId(),"2023-07-15", "11:00 AM - 1:00 PM"));
	    k.add(new Destination(IDGeneration.generateId(),"2023-07-20", "9:00 AM - 11:00 AM"));
	 
	    destinationDates.put("Paris", k);
	    
	    
	    
	    
	    
	    List<Destination> london = new ArrayList();
	    london.add(new Destination(IDGeneration.generateId(),"2023-08-05", "9:30 AM - 11:30 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-08-10", "10:00 AM - 12:00 PM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-08-15", "11:30 AM - 1:30 PM"));
	    
	    
	    destinationDates.put("London", london);
	    
	    List<Destination> newYork = new ArrayList();
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-01", "8:00 AM - 10:00 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-07", "9:30 AM - 11:30 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-15", "10:00 AM - 12:00 PM"));
	    
	    destinationDates.put("NewYork", newYork);
	    
	    
	    List<Destination> bangalore = new ArrayList();
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-01", "8:30 AM - 10:30 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-07", "9:00 AM - 11:00 AM"));
	    london.add(new Destination(IDGeneration.generateId(),"2023-09-15", "10:30 AM - 12:30 PM"));
	    

	    List<Destination> chennai = new ArrayList();
	    chennai.add(new Destination(IDGeneration.generateId(),"2023-09-01", "9:00 AM - 11:00 AM"));
	    chennai.add(new Destination(IDGeneration.generateId(),"2023-09-07", "10:30 AM - 12:30 PM"));
	    chennai.add(new Destination(IDGeneration.generateId(),"2023-09-15", "11:00 AM - 1:00 PM"));
	    
	    
	    destinationDates.put("Chennai", chennai);
	    
	    destinationDates.put("Bangalore",bangalore);

	    try {
	        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("buses.ser"));
	        ois.writeObject(destinationDates);
	    } catch(Exception e) {
	        System.out.println(e.getMessage());
	    }

	    return destinationDates;
	}

	
	public static List<Bookings> bookinFile() {

		List<Bookings> tFile = new ArrayList<>();

		File f = new File("bookings.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {
				tFile =  new ArrayList<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(tFile);

				return tFile;

			} else {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				tFile = (List<Bookings>) ois.readObject();
				return tFile;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return tFile;

	}

	public static Map<String,TravalAgent> credentialsAgent() throws Exception{
		Map<String,TravalAgent> desr = new HashMap<String, TravalAgent>();
		try {
		
		FileOutputStream f = new FileOutputStream("credentials.ser");
		ObjectOutputStream os = new ObjectOutputStream(f);
		
		os.writeObject(desr);
		return desr;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return desr;
	}
	
	

}
