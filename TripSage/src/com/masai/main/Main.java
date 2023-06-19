package com.masai.main;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.masai.exception.InvaildChoiceException;
import com.masai.exception.InvalidCredentialsException;
import com.masai.service.Admin;
import com.masai.service.User;
import com.masai.service.UserService;
import com.masai.utility.FileExist;
import com.masai.utility.IDGeneration;
import com.masai.service.Destination;
import com.masai.service.TravalAgent;
import com.masai.service.TravelAgentService;
import com.masai.service.Bookings;
import com.masai.service.Transaction;
import java.util.ArrayList;
import java.io.*;

public class Main {
	static void AdministratorRole(Scanner sc,List<Bookings> booking,Map<String,List<Destination>> flights,Map<String,List<Destination>> buses,Map<String,Destination>  cancelations ,Map<String,User> credit) throws InvalidCredentialsException, InvaildChoiceException {
		adminLogin(sc);
		int choice = 0;
		
		System.out.println("Login sucessful......");
		boolean exitAdmin = true;
		try {
        while (exitAdmin) {
          //  System.out.println("What would you like to do?");
            //System.out.println("1. Approve Registration");
            System.out.println("2. Handle Account Issue");
            System.out.println("3. Monitor Statistics");
            System.out.println("4. View All Users");
           System.out.println("5. View Customer Details");
            System.out.println("6. Update flights Information");
            System.out.println("7. Update buses Information");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Approve Registration
                    // Prompt for user details and call the approveRegistration() method
                    break;
                case 2:
                    // Handle Account Issue
                    // Prompt for user details and call the handleAccountIssue() method
                //	handleAccountIssue(User)
                    break;
                case 3:
                    // Monitor Statistics
                    monitorStatistics(booking,cancelations);
                    break;
                case 4:
                    // Manage Access Permissions
                	if(credit.size()==0) {
                		throw new InvaildChoiceException(" No Users Available");
                	}
                    UserService.viewAllUser(credit);
                    break;
                case 5:
                    // Moderate Content
                	System.out.println("Enter the Email");
                    UserService.viewCustomerDetails(sc.next(), credit);
                    
                    break;
                case 6:
                    // Update Travel Information
                    updateTravelInformation(sc,flights);
                    break;
                case 7:
		              updateTravelInformation(sc,buses);
		               break;
                case 0:
                    // Exit the program
                    exitAdmin = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

			
		}catch(Exception e) {
			throw new InvaildChoiceException(e.getMessage());
		}
	}
	
	
	  private static void updateTravelInformation(Scanner sc,Map<String, List<Destination>> flights) {
		// TODO Auto-generated method stub
		  List<Destination> k = new ArrayList();
		  System.out.println("Enter the Destination");
		  String d = sc.next();
		  
//		  private int id;
		  System.out.println("Enter the time");
//			private String date;
		  System.out.println("Enter the date");
//			private String time;
		  System.out.println("Enter the Destination");
		  new Destination(IDGeneration.generateId(),sc.next(),sc.next());
		  
		  flights.put(d, k);
		
	}


	public static void monitorStatistics(List<Bookings> booking,Map<String,Destination> cancelations) throws InvaildChoiceException {
	        
	            System.out.println("Monitoring platform statistics...");
	            // Retrieve statistics data or generate dummy data
	            if(booking.size()==0) {
	            	throw new InvaildChoiceException("No Bookings yet");
	            }
	            else {
	            	Bookings.printDesti(booking);
	            }
	            
	            if(cancelations.size()==0) {
	            	throw new InvaildChoiceException(" No Cancelations Yet");
	            }else {
	            	Bookings.printCancel(cancelations);
	            }
	            
	    }
	  
	 
	public static void adminLogin(Scanner sc) throws InvalidCredentialsException {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.userName) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidCredentialsException("Invalid Admin Credentials");
		}
	}
	
	
	public static void user(Scanner input,Map<String, User> credit,List<String> product,Map<String,List<Destination>> fligths,Map<String,Destination> cancels) throws ClassNotFoundException, IOException, Exception,InvalidCredentialsException {
		// TODO Auto-generated method stub
		boolean exit = true;
		do {
			System.out.println("===========================================================");
			System.out.println("Select the option of your choice");
			System.out.println(" 1 : signup");
			System.out.println(" 2 : signin ");
			System.out.println(" 0 : exit");
			int choice = input.nextInt();
			
			switch (choice) {
				case 1:
				    userSignup(input,credit);
				    break;
				case 2:
				    userMenu(input,credit,product,fligths,cancels);
				    break;
				case 0:
				    exit = true;
				    System.out.println("Exiting...");
				    break;
				default:
					System.out.println("Invalid choice. Please try again.");
      
			}
		}while(exit);
		
		
	}
	
	private static void userMenu(Scanner sc,Map<String, User> credit,List<String> product,Map<String,List<Destination>> fligths,Map<String,Destination> cancels) throws InvaildChoiceException, InvalidCredentialsException {
		// TODO Auto-generated method stub
		System.out.println("please enter the following details to login");
		System.out.println("please enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		UserService imp = new UserService();
		userLogin(email,pass,credit,imp);
		boolean exit = true;
		do {
			System.out.println("===========================================================");
			System.out.println("Hello "+credit.get(email).getUserName());
			System.out.println(" 1 : Book destinations with fligths");
			System.out.println (" 2 : Book destinations with Buses");
			System.out.println(" 3 : Cancel the bookings");
			System.out.println(" 4 : exit");
			int choice = sc.nextInt();
			switch (choice) {
            case 1:
                Destination.figths(fligths);;
                
                System.out.println("Enter the destination");
                String k = sc.next().toLowerCase();
                
                booking(sc,"flights",email,k,credit,fligths);
                break;
    
            case 2:
            	 Destination.figths(fligths);
            	 System.out.println("Enter the destionation");
            	 String k1 = sc.next().toLowerCase();
                 
//                 if(!fligths.containsKey(k1)) {
//                 	throw new InvaildChoiceException("fligts not available to the destinations");
//                 }
                 bookingBus(sc,"flights",email,k1,credit,fligths);
                break;
            case 3:
            	System.out.println("enter the email");
            	
            	String ema = sc.next();
//            	if(.containsKey(ema)) {
//            		cancels.put(ema,(Destination) fligths.get(ema));
//            	}
//            	else {
//            		throw new InvaildChoiceException("No ")
//            	}
            	
            	System.out.println("Cancelled Successfully");
            	break;
            	
            	
            	
            case 4:
                exit = true;
                System.out.println("Exiting...");
                break;
            default:
            	System.out.println("Invalid choice. Please try again.");
        }
		}while(exit);
		
		
	}
	
	private static void bookingBus(Scanner sc, String string, String email, String k2, Map<String, User> credit,
			Map<String, List<Destination>> fligths) throws InvalidCredentialsException, InvaildChoiceException {
		// TODO Auto-generated method stub
		
        if(!fligths.containsKey(k2)) {
        	throw new InvaildChoiceException("Buses not available to this destinations");
        }
		System.out.println("Enter the email");
		
		
		if(!email.equals(sc.next())) {
			throw new InvalidCredentialsException("Wrong Email Entered");
		}
		
		System.out.println("No of Passenger");
		int no = sc.nextInt();
		int price = IDGeneration.generatePrice();
		int total = price*no;
		
		System.out.println(price);
		Bookings k1 = new Bookings(price,k2,string,no,email);
		
		
		
		System.out.println("BOOKED SUCESSFULLY");
//		private String userName;
//		private String email;
//		private String destination;
//		private double price;
//		private double total;
//		private LocalDate dt;
		Transaction t = new Transaction(credit.get(email).getUserName(),email,k2,(double)price,(double)total,LocalDate.now());
		
		
	}


	private static void booking(Scanner sc, String transport,String email,String k,Map<String, User> credit,Map<String,List<Destination>> fligths ) throws InvalidCredentialsException, InvaildChoiceException {
//		int id;
//		String destination;
//		String transport;
//		int noOfPassenger;
//		String email;
		
        if(!fligths.containsKey(k)) {
        	throw new InvaildChoiceException("flights not available to this destinations");
        }
		System.out.println("Enter the email");
		
		
		if(!email.equals(sc.next())) {
			throw new InvalidCredentialsException("Wrong Email Entered");
		}
		
		System.out.println("No of Passenger");
		int no = sc.nextInt();
		int price = IDGeneration.generatePrice();
		int total = price*no;
		
		System.out.println(price);
		Bookings k1 = new Bookings(price,k,transport,no,email);
		
		
		
		System.out.println("BOOKED SUCESSFULLY");
//		private String userName;
//		private String email;
//		private String destination;
//		private double price;
//		private double total;
//		private LocalDate dt;
		Transaction t = new Transaction(credit.get(email).getUserName(),email,k,(double)price,(double)total,LocalDate.now());
		
		
	}
	
	
	
	public static void userLogin(String email,String pass, Map<String, User> customers,UserService cusService) throws InvaildChoiceException, InvalidCredentialsException {
		cusService.login(email, pass,customers);
		System.out.println("Customer has successfully login");

	}
	private static void userSignup(Scanner sc,Map<String, User> credit) throws Exception, ClassNotFoundException, InvaildChoiceException, IOException {
		// TODO Auto-generated method stub
		System.out.println("please enter the following details to Signup");
		System.out.println("please enter the user name");
		String name = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		System.out.println("enter the address");
		String address = sc.next();
		System.out.println("Enter the email id");
		String email = sc.next();
	//	System.out.println("Enter the balance to be added into the wallet");
	//	double balance = sc.nextDouble();
		User cus = new User( name, pass, address, email);

		UserService cusService = new UserService();
		cusService.signUp(cus,credit);
		System.out.println("customer has Succefully sign up");
		
		
	}
	public static void travelAgentMenu(Scanner input, Map<String,TravalAgent> travalCredit,Map<String,List<Destination>> flights) throws ClassNotFoundException, IOException, Exception {
		// TODO Auto-generated method stub
		boolean exit = true;
		do {
			System.out.println("===========================================================");
			System.out.println("Select the option of your choice");
			System.out.println(" 1 :Agent signup");
			System.out.println(" 2 :Agent signin ");
			System.out.println(" 0 : exit");
			int choice = input.nextInt();
			
//		 case 1:
//             Destination.figths(fligths);;
//             System.out.println("Enter the destination");
//             String k = sc.next().toLowerCase();
//             
//             if(!fligths.containsKey(k)) {
//             	throw new InvaildChoiceException("fligts not available to the destinations");
//             }
//             booking(sc,"flights",email,k,credit);
//             break;
// 
//         case 2:
//         	 Destination.figths(fligths);
//         	 System.out.println("Enter the destionation");
//         	 String k1 = sc.next().toLowerCase();
//              
//              if(!fligths.containsKey(k1)) {
//              	throw new InvaildChoiceException("fligts not available to the destinations");
//              }
//              booking(sc,"flights",email,k1,credit);
//             break;
//         case 3:
//         	System.out.println("enter the email");
//         	
//         	String ema = sc.next();
////         	if(.containsKey(ema)) {
////         		cancels.put(ema,(Destination) fligths.get(ema));
////         	}
////         	else {
////         		throw new InvaildChoiceException("No ")
////         	}
//         	System.out.println("Cancelled Successfully");
//         	break;
			
			switch (choice) {
				case 1:
				    agentSignup(input,travalCredit);
				    break;
				case 2:
				    agent(input,travalCredit,flights);
				    break;
				case 3:
					System.out.println("enter the email");
	            	
	            	String ema = input.next();
//	            	if(.containsKey(ema)) {
//	            		cancels.put(ema,(Destination) fligths.get(ema));
//	            	}
//	            	else {
//	            		throw new InvaildChoiceException("No ")
//	            	}
	            	System.out.println("Cancelled Successfully");
	            	break;
	
				case 0:
				    exit = true;
				    System.out.println("Exiting...");
				    break;
				default:
				    System.out.println("Invalid choice. Please try again.");
      
			}
		}while(exit);
		
		
	}
	private static void bookingAgent(Scanner sc, String transport,String email,String k,Map<String, TravalAgent> credit ) throws InvalidCredentialsException {
//		int id;
//		String destination;
//		String transport;
//		int noOfPassenger;
//		String email;
		
		System.out.println("Enter the email");
		
		
		if(!email.equals(sc.next())) {
			throw new InvalidCredentialsException("Wrong Email Entered");
		}
		
		System.out.println("No of Passenger");
		int no = sc.nextInt();
		int price = IDGeneration.generatePrice();
		int total = price*no;
		
		System.out.println(price);
		Bookings k1 = new Bookings(price,k,transport,no,email);
		
		
		
		System.out.println("BOOKED SUCESSFULLY");
//		private String userName;
//		private String email;
//		private String destination;
//		private double price;
//		private double total;
//		private LocalDate dt;
		Transaction t = new Transaction(credit.get(email).getUserName(),email,k,(double)price,(double)total,LocalDate.now());
		
		
	}
	private static void agent(Scanner sc,Map<String, TravalAgent> credit,Map<String , List<Destination>> fligths) throws InvaildChoiceException, InvalidCredentialsException {
		// TODO Auto-generated method stub
		System.out.println("please enter the following details to login");
		System.out.println("please enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		TravelAgentService imp = new TravelAgentService();
		agentLogin(email,pass,credit,imp);
		boolean exit = true;
		do {
			System.out.println("===========================================================");
			System.out.println("Hello "+credit.get(email).getUserName());
			System.out.println(" 1 : Book destinations with flights");
			System.out.println (" 2 : Book destinations with Buses");
			System.out.println( " 3 : Cancellations");
			System.out.println(" 4 : exit");
			int choice = sc.nextInt();
			switch (choice) {
            case 1:
               // Destination.viewDestinations();
                
                Destination.figths(fligths);;
              System.out.println("Enter the destination");
              String k = sc.next().toLowerCase();
              
              if(!fligths.containsKey(k)) {
            	  System.out.println("fligts not available to the destinations");
              }else {
              bookingAgent(sc,"flights",email,k,credit);
              }
              break;
            case 2:

                Destination.figths(fligths);;
              System.out.println("Enter the destination");
              String k1 = sc.next().toLowerCase();
              
              if(!fligths.containsKey(k1)) {
            	  System.out.println("fligts not available to the destinations");
              }else {
              bookingAgent(sc,"flights",email,k1,credit);
              }
              break;
               // break;
            case 3:
            	System.out.println("enter the email");
            	
            	String ema = sc.next();
//            	if(.containsKey(ema)) {
//            		cancels.put(ema,(Destination) fligths.get(ema));
//            	}
//            	else {
//            		throw new InvaildChoiceException("No ")
//            	}
            	System.out.println("Cancelled Successfully");
            	break;
            case 0:
                exit = true;
                System.out.println("Exiting...");
                break;
            default:
            	System.out.println("Invalid choice. Please try again.");
        }
		}while(exit);
		
		
	}
	
	
	public static void agentLogin(String email,String pass, Map<String, TravalAgent> customers,TravelAgentService cusService) throws InvaildChoiceException, InvalidCredentialsException {
		cusService.login(email, pass,customers);
		System.out.println("Customer has successfully login");

	}
	
	private static void agentSignup(Scanner sc,Map<String,TravalAgent> credit) throws Exception, ClassNotFoundException, InvaildChoiceException, IOException {
		// TODO Auto-generated method stub
		System.out.println("please enter the following details to Signup");
		System.out.println("please enter the user name");
		String name = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		System.out.println("enter the address");
		String address = sc.next();
		System.out.println("Enter the email id");
		String email = sc.next();
		String qualification = sc.next();
		if(!qualification.equalsIgnoreCase("tourism")) {
			throw new InvalidCredentialsException("User credential not approved");
		}
	//	System.out.println("Enter the balance to be added into the wallet");
	//	double balance = sc.nextDouble();
		TravalAgent cus = new TravalAgent( name, pass, address, email,qualification);

		TravelAgentService cusService = new TravelAgentService();
		cusService.signUp(cus,credit);
		credit.put(email, cus);
		System.out.println("customer has Succefully sign up");
		
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		List<String> products = FileExist.destination();
		Map<String, User> userCredit = FileExist.credentialsUser();
		Map<String , TravalAgent> travalCredit = FileExist.credentialsAgent();
		Map<String , List<Destination>> fliDetails = FileExist.flights();
		Map<String , List<Destination>> busDetails = FileExist.Buses();
		List<Bookings> bookings = FileExist.bookinFile();
		Map<String,Destination> cancels = FileExist.cancel();
		
		//List<Transaction> transactions = FileExists.transactionFile();
	try {
		boolean exit = true;
		do {
			System.out.println("===========================================================");
			System.out.println("WELCOME TO THE TRIPSAGE");
			System.out.println(" 1 : Admin");
			System.out.println(" 2 : TravelAgent");
			System.out.println(" 3 : User");
			System.out.println(" 4 : exit");
			int choice = input.nextInt();
			switch (choice) {
            case 1:
                AdministratorRole(input,bookings,fliDetails,busDetails,cancels,userCredit);
                break;
            case 2:
            	travelAgentMenu(input,travalCredit,fliDetails);
                break;
            case 3:
                user(input,userCredit,products,fliDetails,cancels);
                break;
            case 0:
                exit = true;
                System.out.println("Exiting...");
                break;
            default:
                throw new InvaildChoiceException("Invalid choice. Please try again.");
        }
		}while(exit);
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {
		try {
//			List<String> products = FileExist.destination();
//			Map<String, User> userCredit = FileExist.credentialsUser();
//			Map<String , TravalAgent> travalCredit = FileExist.credentialsAgent();
//			Map<String , List<Destination>> fliDetails = FileExist.flights();
//			Map<String , List<Destination>> busDetails = FileExist.Buses();
//			List<Bookings> bookings = FileExist.bookinFile();
//			Map<String,Destination> cancels = FileExist.cancel();
			
			ObjectOutputStream poss = new ObjectOutputStream(new FileOutputStream("destination.ser"));
			poss.writeObject(products);
			
			ObjectOutputStream coss = new ObjectOutputStream(new FileOutputStream("credentialsUser.ser"));
			coss.writeObject(userCredit);
			
			ObjectOutputStream a5 = new ObjectOutputStream(new FileOutputStream("credentials.ser"));
			a5.writeObject(travalCredit);
			
			ObjectOutputStream fliDetatils = new ObjectOutputStream(new FileOutputStream("flights.ser"));
			fliDetatils.writeObject(fliDetails);
			
			ObjectOutputStream busDetailss = new ObjectOutputStream(new FileOutputStream("buses.ser"));
			busDetailss.writeObject(busDetails);
			
			ObjectOutputStream bookingss = new ObjectOutputStream(new FileOutputStream("bookings.ser"));
			bookingss.writeObject(bookings);
			
			ObjectOutputStream cancelss = new ObjectOutputStream(new FileOutputStream("cancels.ser"));
			cancelss.writeObject(cancels);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	}
	
}
