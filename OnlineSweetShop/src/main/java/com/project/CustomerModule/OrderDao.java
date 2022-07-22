package com.project.CustomerModule;

public interface OrderDao {
	public void placeorder(OrderPojo object); // place an order

	public void vieworder(int orderid, String sweetname, String brand); // view the order
}
