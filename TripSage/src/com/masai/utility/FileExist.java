package com.masai.utility;
import java.io.Serializable;
import com.masai.service.User;
import com.masai.service.TravalAgent;
import java.util.List;

import com.masai.service.Destination;

import java.util.ArrayList;
import java.io.*;

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
	
	public static Map<String,User> credentialsUser(){
		
	}
}
