package com.flightmanage.common;

import com.flightmanage.entity.User;

public class Userrequest {
	private User user;
	private Booking booking;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Userrequest(User user, Booking booking) {
		super();
		this.user = user;
		this.booking = booking;
	}

	public Userrequest() {
		super();
	}

}
