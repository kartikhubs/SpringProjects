package io.usersys.Usersystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertb")
public class Userpojo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userID;
	private String password;
	private String confirmPassword;
	private Long phoneNumber;
	private String email;

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Userpojo(Long userID, String password, String confirmPassword, Long phoneNumber, String email) {
		super();
		this.userID = userID;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Userpojo() {
		super();
	}

}
