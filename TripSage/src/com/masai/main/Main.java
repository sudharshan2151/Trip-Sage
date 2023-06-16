package com.masai.main;

import java.util.Scanner;
import com.masai.exception.InvaildChoiceException;
import com.masai.exception.InvaildCredentials;
import com.masai.service.Admin;

public class Main {
	static void AdministratorRole(Scanner input) {
		int choice = 0;
		try {
			do {
				System.out.println("Press 1 add the product");
				System.out.println("Press 2 view all the product");
				System.out.println("Press 3 delete the product");
				System.out.println("Press 4 update the product");
				System.out.println("Press 5 view all customers");
				System.out.println("Press 6 to view all transactions");
				System.out.println("Press 7 to log out");
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
	}
	}
	public static void adminLogin(Scanner sc) throws InvaildCredentials {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvaildCredentials("Invalid Admin Credentials");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean exit = true;
		do {
			System.out.println("===========================================================");
			System.out.println("WELCOME TO THE TRIPSAGE");
			int choice = input.nextInt();
			switch (choice) {
            case 1:
                AdministratorRole(input);
                break;
            case 2:
                TravelAgentRole.travelAgentMenu();
                break;
            case 3:
                UserRole.userMenu();
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
