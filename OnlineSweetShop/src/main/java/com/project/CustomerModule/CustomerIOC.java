package com.project.CustomerModule;

import org.springframework.context.ApplicationContext;

import com.project.AdminModule.SweetDaoImp;

import org.springframework.context.support.ClassPathXmlApplicationContext; //this class implements the ApplicationContext
import java.util.*; //for Scanner class

public class CustomerIOC {

	public static void main(String args[]) {
		System.out.println("Press 1 to register"); // If you are registered, login, else, register
		System.out.println("Press 2 to login");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt(); // user input
		if (input == 1) {
			System.out.println("Welcome to Customer Module--------******----------"); // registering portal

			System.out.println("Enter your username:"); // details:username,password,confirm
														// password,city,state,pincode(stored in Customerrtable in
														// SECOND database)
			String uname = sc.next();

			System.out.println("Enter your password:");
			String password = sc.next();

			System.out.println("Confirm the password:");
			String confirm = sc.next();
			if (password.equals(confirm)) {
				System.out.println("Enter your city:");

				String city = sc.next();

				System.out.println("Emter your state:");
				String state = sc.next();

				System.out.println("Enter your city pincode:");
				int pincode = sc.nextInt();
				ApplicationContext context = new ClassPathXmlApplicationContext("ConfigurationDev.xml");
				CustomerDaoImp object = (CustomerDaoImp) context.getBean("CUSTOMER", CustomerDaoImp.class); // bean
																											// instantiating
																											// (ConfigurationDev.xml
																											// file)
				CustomerPojo pobj = new CustomerPojo(uname, password, confirm, city, state, pincode);
				object.register(pobj); // method call
				System.out.println("You are registered!!!!!");
				((ClassPathXmlApplicationContext) context).close();

			} else {
				System.out.println("Password did not match.....try again"); // password logic

			}
			sc.close();
		} else if (input == 2) { // LOGIN portal
			Scanner br = new Scanner(System.in);
			ApplicationContext context = new ClassPathXmlApplicationContext("ConfigurationDev.xml");
			CustomerDaoImp object = (CustomerDaoImp) context.getBean("CUSTOMER", CustomerDaoImp.class);

			ApplicationContext contextOne = new ClassPathXmlApplicationContext("ConfigurationDev.xml");

			System.out.println("Login into customer portal-------*******--------");

			System.out.println("Enter username:");
			String uname = br.next();

			System.out.println("Enter password:");
			String password = br.next();

			boolean ans = object.login(uname, password); // login method(connecting to the databse)
			if (ans == true) {
				System.out.println("Logging successful!!!!");

				System.out.println("Press 1 for viewing sweet category");
				System.out.println("Press 2 for viewing product");
				System.out.println("Press 3 for viewing whole menu");
				System.out.println("Press 4 for placing order");
				System.out.println("Press 5 for viewing order");
				System.out.println("Press 6 for getting the invoice(final bill)");

				int userinput = br.nextInt();
				if (userinput == 1) { // showcatalogue() in SweetDaoImp
					System.out.println("Enter the category you want to see today(enter numeric):");

					int categoryid = br.nextInt();

					SweetDaoImp sweetDao = (SweetDaoImp) contextOne.getBean("KARTIKONE", SweetDaoImp.class);
					sweetDao.showcatalogue(categoryid);

				} else if (userinput == 2) { // showproducts() method in SweetDaoImp
					System.out.println("The products(brand) of sweets are");

					SweetDaoImp sweetDao = (SweetDaoImp) contextOne.getBean("KARTIKONE", SweetDaoImp.class);
					sweetDao.showproducts();

				} else if (userinput == 3) { // showmenu() method in SweetDaoImp
					System.out.println("Your menu is:");
					SweetDaoImp sweetDao = (SweetDaoImp) contextOne.getBean("KARTIKONE", SweetDaoImp.class);
					sweetDao.showmenu();
					((ClassPathXmlApplicationContext) contextOne).close();
				} else if (userinput == 4) {
					try {
						System.out.println("Placing order:");
						ApplicationContext ordercontext = new ClassPathXmlApplicationContext("ConfigurationDev.xml");

						OrderDaoImp orderDao = (OrderDaoImp) ordercontext.getBean("ORDER", OrderDaoImp.class);
						System.out.println("Enter order id:");
						int orderid = br.nextInt();
						System.out.println("Enter the brand:");
						String brand = br.next();
						System.out.println();
						System.out.println("Enter sweetname:");
						String sweet = br.next();

						OrderPojo orderobject = new OrderPojo(orderid, sweet, brand);
						orderDao.placeorder(orderobject); // placeorder() method in OrderDaoImp
						((ClassPathXmlApplicationContext) ordercontext).close();
					} catch (Exception e) {
						System.out.println("Order already placed with this id..!");
					}

					((ClassPathXmlApplicationContext) context).close();
				}

				else if (userinput == 5) {
					System.out.println("Viewing my order:");

					ApplicationContext ordercontext = new ClassPathXmlApplicationContext("ConfigurationDev.xml");

					OrderDaoImp orderDao = (OrderDaoImp) ordercontext.getBean("ORDER", OrderDaoImp.class);
					System.out.println("Enter the order id you entered:");
					int orderid = br.nextInt();

					System.out.println("Enter the sweetname you purchased:");
					String sweetname = br.next();

					System.out.println();
					System.out.println("Enter the brand name of the sweet you purchased");
					String brand = br.next();

					orderDao.vieworder(orderid, sweetname, brand);
					((ClassPathXmlApplicationContext) ordercontext).close();

				} else if (userinput == 6) {
					System.out.println("Your final bill checkout is here(after deduction):");
					ApplicationContext ordercontext = new ClassPathXmlApplicationContext("ConfigurationDev.xml");
					CustomerDaoImp custobject = (CustomerDaoImp) ordercontext.getBean("CUSTOMER", CustomerDaoImp.class);
					System.out.println("Enter your orderid again to validate:");
					int orderid = br.nextInt();
					custobject.invoiceAfterOffer(orderid);
					((ClassPathXmlApplicationContext) ordercontext).close();
				}

			}

			else { // entered wrong credentials(hence declined)
				System.out.println("Invalid credentials sorry...!");
			}
			br.close();
		}
	}
}
