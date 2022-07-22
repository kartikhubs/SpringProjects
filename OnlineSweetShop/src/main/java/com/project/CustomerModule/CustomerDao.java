package com.project.CustomerModule;

public interface CustomerDao {
	public void register(CustomerPojo cobj); // customers registers in the customer portal

	public boolean login(String uname, String password); // customers logins

	public void showmenu(); // customers will be displayed all details of the sweet(categoryid, brand,
							// price,offer etc)

	public void invoiceAfterOffer(int orderid); // customers will be displayed final bill after applied offer

}
