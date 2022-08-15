package com.passenger.entity;

public class Passenger {
	private Long pnr; // data members for passenger microservice
	private String pname;
	private int page;
	private int puin;
	private Long bookingid; // connected via bookingid
	private Long userid;

	// getter and setters
	public Long getPnr() {
		return pnr;
	}

	public void setPnr(Long pnr) {
		this.pnr = pnr;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPuin() {
		return puin;
	}

	public void setPuin(int puin) {
		this.puin = puin;
	}

	public Long getBookingid() {
		return bookingid;
	}

	public void setBookingid(Long bookingid) {
		this.bookingid = bookingid;
	}
	

	// parameterized constructor
	public Passenger(Long pnr, String pname, int page, int puin, Long bookingid) {
		super();
		this.pnr = pnr;
		this.pname = pname;
		this.page = page;
		this.puin = puin;
		this.bookingid = bookingid;
	}

	// default constructor
	public Passenger() {
		super();
	}

}
