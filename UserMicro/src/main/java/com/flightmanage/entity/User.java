package com.flightmanage.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	// data members
	private String usertype;
	private Long userid;
	private String username;
	private String userpwd;
	private Long userphone;
	private String email;

	List<Booking> bookingdetails = new ArrayList<Booking>(); // User will display booking details via userid

	// getters and setters
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public Long getUserphone() {
		return userphone;
	}

	public void setUserphone(Long userphone) {
		this.userphone = userphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Booking> getBookingdetails() {
		return bookingdetails;
	}

	public void setBookingdetails(List<Booking> bookingdetails) {
		this.bookingdetails = bookingdetails;
	}

	// parameterized constructor
	public User(String usertype, Long userid, String username, String userpwd, Long userphone, String email,
			List<Booking> bookingdetails) {
		super();
		this.usertype = usertype;
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.userphone = userphone;
		this.email = email;
		this.bookingdetails = bookingdetails;
	}

	// paramaterized constructor
	public User(String usertype, Long userid, String username, String userpwd, Long userphone, String email) {
		super();
		this.usertype = usertype;
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.userphone = userphone;
		this.email = email;
	}

	// default constructor
	public User() {
		super();
	}

}
