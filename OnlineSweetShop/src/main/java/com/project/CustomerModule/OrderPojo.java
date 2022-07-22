package com.project.CustomerModule;

public class OrderPojo {

	private int orderid; // data members
	private String sweetname;
	private String brand;

	public OrderPojo() { // default constructor
		super();
	}

	public OrderPojo(int orderid, String sweetname, String brand) { // parameterized constructor
		super();
		this.orderid = orderid;
		this.sweetname = sweetname;
		this.brand = brand;
	}

	public int getOrderid() { // getters and setters
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getSweetname() {
		return sweetname;
	}

	public void setSweetname(String sweetname) {
		this.sweetname = sweetname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override // display
	public String toString() {
		return "OrderPojo [orderid=" + orderid + ", sweetname=" + sweetname + ", brand=" + brand + "]";
	}

}
