package com.flightmanage.common;

public class Passenger {
	private Long pnr;
	private String pname;
	private int page;
	private int puin;
	private Long bookingid;
	private Long userid;

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

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Passenger(Long pnr, String pname, int page, int puin, Long bookingid, Long userid) {
		super();
		this.pnr = pnr;
		this.pname = pname;
		this.page = page;
		this.puin = puin;
		this.bookingid = bookingid;
		this.userid = userid;
	}

	public Passenger() {
		super();
	}

}