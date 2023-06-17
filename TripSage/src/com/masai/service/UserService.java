package com.masai.service;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.text.ParseException;
	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.LinkedHashSet;
	import java.util.List;
	import java.util.Map;
	import java.util.Set;

import com.masai.exception.InvaildChoiceException;;

public class UserService {
	

		public void signUp(User cus, Map<String, User> customers) throws InvaildChoiceException {

			if (customers.containsKey(cus.getEmail())) {
				throw new InvaildChoiceException("Customer already exists , please login");
			} else {

				customers.put(cus.getEmail(), cus);

			}

		}

		
		public boolean login(String email,String password, Map<String, User> customers) throws InvaildChoiceException {

			if (customers.containsKey(email) ) {
				
				if(customers.get(email).getPassword().equals(password)) {
					return true;
				}
				else {
					throw new InvaildChoiceException("Invalid Credentials");
				}
				
			} else {
				throw new InvaildChoiceException("you have not sign up yet, please signup");
			}

		}
//
//		@Override
//		public boolean buyProduct(int id, int qty, String email, Map<Integer, Product> products,
//				Map<String, Customer> customers, List<Transaction> transactions)
//				throws InvalidDetailsException, ProductException {
//
//			if (products.size() == 0)
//				throw new ProductException("Product list is empty");
//
//			if (products.containsKey(id)) {
//
//				Product prod = products.get(id);
//
//				if (prod.getQty() >= qty) {
//
//					Customer cus = customers.get(email);
//
//					double buyingPrice = qty * prod.getPrice();
//
//					if (cus.getWalletBalance() >= buyingPrice) {
//						cus.setWalletBalance(cus.getWalletBalance() - buyingPrice);
//
//						prod.setQty(prod.getQty() - qty);
//
//						products.put(id, prod);
//
//						Transaction tr = new Transaction(cus.getUsername(), email, id,prod.getName(), qty, prod.getPrice(),
//								prod.getPrice() * qty, LocalDate.now());
//
//						transactions.add(tr);
//
//					} else {
//						throw new InvalidDetailsException("wallet balance is not sufficient");
//					}
//
//				} else {
//					throw new InvalidDetailsException("product quantity is not suffiecient");
//				}
//
//			} else {
//				throw new InvalidDetailsException("product not available with id: " + id);
//			}
//
//			return false;
//		}

		

		

		public User viewCustomerDetails(String email, Map<String, User> customers) {

			if (customers.containsKey(email)) {

				return customers.get(email);

			}

			return null;
		}

		
	}

}
