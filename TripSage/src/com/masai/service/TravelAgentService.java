package com.masai.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.masai.exception.InvaildChoiceException;
import com.masai.exception.InvalidCredentialsException;

public class TravelAgentService {
	
	public void signUp(TravalAgent cus, Map<String, TravalAgent> customers) throws InvaildChoiceException, Exception{

		if (customers.containsKey(cus.getEmail())) {
			throw new InvaildChoiceException("Customer already exists , please login");
		} else {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("travelCredentials.ser"));
			Map<String,TravalAgent> pFile = (Map<String, TravalAgent>) ois.readObject();
			Map<String,TravalAgent> k = new HashMap<>();
			if(k!=null)
				k.putAll(pFile);
			k.put(cus.getEmail(),cus);
			ObjectOutputStream ot = new ObjectOutputStream(new FileOutputStream("travelCredentials.ser"));
			ot.writeObject(k);
				

			customers.put(cus.getEmail(), cus);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		}

	}
	
	public boolean login(String email,String password, Map<String, TravalAgent> customers) throws InvaildChoiceException, InvalidCredentialsException {

		if (customers.containsKey(email) ) {
			
			if(customers.get(email).getPassword().equals(password)) {
				return true;
			}
			else{
				throw new InvalidCredentialsException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidCredentialsException("you have not sign up yet, please signup");
		}

	}
	

	public TravalAgent viewCustomerDetails(String email, Map<String, TravalAgent> customers) {

		if (customers.containsKey(email)) {

			return customers.get(email);

		}

		return null;
	}

}
