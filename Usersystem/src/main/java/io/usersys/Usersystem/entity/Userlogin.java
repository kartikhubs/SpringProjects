package io.usersys.Usersystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Userlogin {
	@Id
	private Long userID;
	private String password;

	public Userlogin(Long userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Userlogin() {
		super();
	}

}
