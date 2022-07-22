package com.project.CustomerModule;

public class CustomerPojo {

	private String uname;
	private String password;
	private String confirm; // data members
	private String city;
	private String state;
	private int pincode;

	public CustomerPojo() { // default constructor
		super();
	}

	public CustomerPojo(String uname, String password, String confirm, String city, String state, int pincode) { // parameterized
																													// constrcutor
		super();
		this.uname = uname;
		this.password = password;
		this.confirm = confirm;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	// getters and setters
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override // display the details(toString())
	public String toString() {
		return "CustomerPojo [uname=" + uname + ", password=" + password + ", confirm=" + confirm + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}

}
