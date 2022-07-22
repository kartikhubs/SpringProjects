package com.project.AdminModule; //package

public class AdminPojo {

	private int userid; // private data members
	private String username;
	private int password;

	public AdminPojo() { // default constructor
		super();
	}

	public AdminPojo(int userid, String username, int password) { // parameterized constructor
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}

	public int getUserid() { // getters and setters
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override // displaying output
	public String toString() {
		return "Developer [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}

}
