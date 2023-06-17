package com.masai.main;

import java.util.Map;
import java.util.Scanner;
import com.masai.exception.InvaildChoiceException;
import com.masai.exception.InvaildCredentials;
import com.masai.service.Admin;
import com.masai.service.User;
import com.masai.service.UserService;
import com.masai.utility.FileExist;

public class Main {
	static void AdministratorRole(Scanner sc) {
		adminLogin(sc);
		int choice = 0;
		
		try {
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

				switch (choice) {
				case 1:
					String added = adminAddProduct(sc, products, prodService);
					System.out.println(added);
					break;
				case 2:

					adminViewAllProducts(products, prodService);
					break;
				case 3:

					adminDeleteProduct(sc, products, prodService);
					break;
				case 4:

					String upt = adminUpdateProduct(sc, products, prodService);
					System.out.println(upt);
					break;
				case 5:
					adminViewAllCustomers(customers, cusService);

					break;
				case 6:
					adminViewAllTransactions(transactions, trnsactionService);
					break;
				case 7:
					System.out.println("admin has successfully logout");
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 6);
		}catch(Exception e) {
			throw new InvaildChoiceException(e.getMessage());
		}
	}
	public static void adminLogin(Scanner sc) throws InvaildCredentials {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.userName) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvaildCredentials("Invalid Admin Credentials");
		}
	}
	public static void user(Scanner input) {
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
                userSignup(input);
                break;
            case 2:
                userMenu(input);
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
	private static void userMenu(Scanner sc,Map<String, User> credit) {
		// TODO Auto-generated method stub
		System.out.println("please enter the following details to login");
		System.out.println("please enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		userLogin(email,pass,credit);
		
	}
	public static void userLogin(String email,String pass, Map<String, User> customers,UserService cusService) throws InvaildChoiceException {
		cusService.login(email, pass,customers);
		System.out.println("Customer has successfully login");

	}
	private static void userSignup(Scanner input) {
		// TODO Auto-generated method stub
		
		
	}
	public static void travelAgentMenu(Scanner input) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		//Map<Integer, Product> products = FileExist.destinations();
		Map<String, User> userCredit = FileExist.credentialsUser();
		//List<Transaction> transactions = FileExists.transactionFile();
		boolean exit = true;
		do {
			System.out.println("===========================================================");
			System.out.println("WELCOME TO THE TRIPSAGE");
			System.out.println(" 1 : Admin");
			System.out.println(" 2 : TravelAgent");
			System.out.println(" 3 : User");
			int choice = input.nextInt();
			switch (choice) {
            case 1:
                AdministratorRole(input);
                break;
            case 2:
                travelAgentMenu(input);
                break;
            case 3:
                user(input,userCredit);
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
