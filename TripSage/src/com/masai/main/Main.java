package com.masai.main;

import java.io.FileNotFoundException;''
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

public class Main {
	static void AdministratorRole(Scanner sc) throws InvalidCredentialsException {
		adminLogin(sc);
		int choice = 0;
		
		
			do {
				System.out.println("Press 1 bookings");
				System.out.println("Press 2 cancellations");
				System.out.println("Press 3 revenue");
				System.out.println("Press 4 destinations");
				System.out.println("Press 5 accomadations");
				System.out.println("Press 6 flights");
				System.out.println("Press 7 transporation");
				System.out.println("Press 8 to log out");
				choice = sc.nextInt();

//				switch (choice) {
//				case 1:
//					String added = adminAddProduct(sc, products, prodService);
//					System.out.println(added);
//					break;
//				case 2:
//
//					adminViewAllProducts(products, prodService);
//					break;
//				case 3:
//
//					adminDeleteProduct(sc, products, prodService);
//					break;
//				case 4:
//
//					String upt = adminUpdateProduct(sc, products, prodService);
//					System.out.println(upt);
//					break;
//				case 5:
//					adminViewAllCustomers(customers, cusService);
//
//					break;
//				case 6:
//					adminViewAllTransactions(transactions, trnsactionService);
//					break;
//				case 7:
//					System.out.println("admin has successfully logout");
//					break;
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + choice);
//				}

			} while (choice <= 6);
//		}catch(Exception e) {
//			throw new InvaildChoiceException(e.getMessage());
//		}
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
	public static void user(Scanner input,Map<String, User> credit,List<String> product,Map<String,List<Destination>> fligths) throws ClassNotFoundException, IOException, Exception,InvalidCredentialsException {
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
				    userMenu(input,credit,product,fligths);
				    break;
				case 0:
				    exit = true;
				    System.out.println("Exiting...");
				    break;
				default:
				    throw new InvaildChoiceException("Invalid choice. Please try again.");
      
			}
		}while(exit);
		
		
	}
	private static void userMenu(Scanner sc,Map<String, User> credit,List<String> product,Map<String,List<Destination>> fligths) throws InvaildChoiceException, InvalidCredentialsException {
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
			
			System.out.println(" 4 : exit");
			int choice = sc.nextInt();
			switch (choice) {
            case 1:
                Destination.figths(fligths);;
                System.out.println("Enter the destination");
                String k = sc.next().toLowerCase();
                
                if(!fligths.containsKey(k)) {
                	throw new InvaildChoiceException("fligts not available to the destinations");
                }
                booking(sc,"flights",email,k);
                break;
    
            case 2:
            	 Destination.figths(fligths);
            	 System.out.println("Enter the Id");
                travelAgentMenu(input);
                break;
            case 3:
                user(sc,credit);
                break;
            case 0:
                exit = true;
                System.out.println("Exiting...");
                break;
            default:
                throw new InvaildChoiceException("Invalid choice. Please try again.");
        }
		}while(exit);
		
		
	}
	
	private static void booking(Scanner sc, String transport,String email,String k ) {
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
		Transaction t = new Transaction(credit.get(email).getUserName()),email,k,total,LocalDate.now)
		
	}
	
	
	private static void addDestination(Scanner sc,) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Destinations");
		
		
		
		
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
	public static void travelAgentMenu(Scanner input,List<String> product, Map<String,TravalAgent> travalCredit) {
		// TODO Auto-generated method stub
		boolean exit = true;
		do {
			System.out.println("===========================================================");
			System.out.println("Select the option of your choice");
			System.out.println(" 1 :Agent signup");
			System.out.println(" 2 :Agent signin ");
			System.out.println(" 0 : exit");
			int choice = input.nextInt();
			
			switch (choice) {
				case 1:
				    agentSignup(input,travalCredit);
				    break;
				case 2:
				    agent(input,travalCredit,product);
				    break;
				case 0:
				    exit = true;
				    System.out.println("Exiting...");
				    break;
				default:
				    throw new InvaildChoiceException("Invalid choice. Please try again.");
      
			}
		}while(exit);
		
		
	}
	private static void agent(Scanner sc,Map<String, TravalAgent> credit,List<String> product) throws InvaildChoiceException, InvalidCredentialsException {
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
			
			System.out.println(" 4 : exit");
			int choice = sc.nextInt();
			switch (choice) {
            case 1:
                Destination.viewDestinations();
                System.out.println("Enter the Destionation");
                String k = sc.next();
                
                break;
            case 2:
                travelAgentMenu(input);
                break;
            case 3:
                user(sc,credit);
                break;
            case 0:
                exit = true;
                System.out.println("Exiting...");
                break;
            default:
                throw new InvaildChoiceException("Invalid choice. Please try again.");
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
	//	System.out.println("Enter the balance to be added into the wallet");
	//	double balance = sc.nextDouble();
		TravalAgent cus = new TravalAgent( name, pass, address, email,qualification);

		TravelAgentService cusService = new TravelAgentService();
		cusService.signUp(cus,credit);
		System.out.println("customer has Succefully sign up");
		
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		List<String> products = FileExist.destination();
		Map<String, User> userCredit = FileExist.credentialsUser();
		Map<String , TravalAgent> travalCredit = FileExist.credentialsAgent();
		Map<String , List<Destination>> fliDetails = FileExist.flights();
		Map<String , List<Destination>> busDetails = FileExist.Buses();
		
		//List<Transaction> transactions = FileExists.transactionFile();
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
                AdministratorRole(input);
                break;
            case 2:
                travelAgentMenu(input,products,travalCredit);
                break;
            case 3:
                user(input,userCredit,products,fliDetails);
                break;
            case 0:
                exit = true;
                System.out.println("Exiting...");
                break;
            default:
                throw new InvaildChoiceException("Invalid choice. Please try again.");
        }
		}while(exit);
	}
	
}
