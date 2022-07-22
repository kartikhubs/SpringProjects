package com.project.AdminModule;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

public class AdminIOC {
	public static void main(String[] args) {

		System.out.println("Press 1 for Registering"); // admin priviledges
		System.out.println("Press 2 for managing sweets");
		System.out.println("Press 3 to see the orders for today");
		System.out.println("Press 4 to delete the order entry");
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		if (input == 1) {

			try {
				System.out.println("Welcome to Admin Module---------*****---------");
				System.out.println("Enter User id:");
				int userid = sc.nextInt();

				System.out.println("Enter Username:");
				String username = sc.next();

				System.out.println("Enter Password(password should be numeric):"); // password is numeric
				int password = sc.nextInt();
				ApplicationContext context = new ClassPathXmlApplicationContext("ConfigurationDev.xml");

				AdminDaoImp adminDao = (AdminDaoImp) context.getBean("KARTIK", AdminDaoImp.class); // insert operation
				AdminPojo obj = new AdminPojo(userid, username, password);
				adminDao.logging(obj);

				System.out.println("Admin logged");

				System.out.println("---------******----------");

				((ClassPathXmlApplicationContext) context).close();

			} catch (Exception e) {
				System.out.println("Already registered or incorect details");
			}

		} else if (input == 2) {

			System.out.println("Welcome to sweet management portal-----*****------"); // Sweet Management portal
			System.out.println("Enter category id of the sweet:");
			int categoryid = sc.nextInt();

			System.out.println("Enter brand:");
			String brand = sc.next();

			System.out.println("Enter name of the sweet:");
			String sweetname = sc.next();

			System.out.println("Enter the price:");
			double price = sc.nextDouble();

			System.out.println("Enter the offer for this sweet:");

			double offer = sc.nextDouble();

			ApplicationContext contextOne = new ClassPathXmlApplicationContext("ConfigurationDev.xml");
			SweetDaoImp sweetDao = (SweetDaoImp) contextOne.getBean("KARTIKONE", SweetDaoImp.class); // xml file

			SweetPojo obj1 = new SweetPojo(categoryid, sweetname, brand, price, offer);

			sweetDao.manage(obj1);
			((ClassPathXmlApplicationContext) contextOne).close();

		} else if (input == 3) {
			System.out.println("Orders for today are:");
			ApplicationContext contextOne = new ClassPathXmlApplicationContext("ConfigurationDev.xml");
			SweetDaoImp sweetDao = (SweetDaoImp) contextOne.getBean("KARTIKONE", SweetDaoImp.class); // xml file

			sweetDao.showAllorders();
			((ClassPathXmlApplicationContext) contextOne).close();

		} else if (input == 4) {
			System.out.println("You are deleting----***------");
			ApplicationContext contextOne = new ClassPathXmlApplicationContext("ConfigurationDev.xml");
			SweetDaoImp sweetDao = (SweetDaoImp) contextOne.getBean("KARTIKONE", SweetDaoImp.class); // xml file
			System.out.println("Enter the orderid you want to remove:");
			int orderid = sc.nextInt();
			sweetDao.deletesweet(orderid);
			((ClassPathXmlApplicationContext) contextOne).close();

		}
		sc.close();

	}
}
