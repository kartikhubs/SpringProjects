package com.project.AdminModule;

public class SweetPojo {

	private int categoryid;

	private String sweetname;
	private String brand;
	private double price;
	private double offer;

	public SweetPojo() {
		super();
	}

	public SweetPojo(int categoryid, String sweetname, String brand, double price, double offer) {
		super();
		this.categoryid = categoryid;
		this.sweetname = sweetname;
		this.brand = brand;
		this.price = price;
		this.offer = offer;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "SweetPojo [categoryid=" + categoryid + ", sweetname=" + sweetname + ", brand=" + brand + ", price="
				+ price + ", offer=" + offer + "]";
	}

}
