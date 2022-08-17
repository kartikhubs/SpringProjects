package io.usersys.Usersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.usersys.Usersystem.entity.Userlogin;
import io.usersys.Usersystem.entity.Userpojo;
import io.usersys.Usersystem.repository.Loginrepo;
import io.usersys.Usersystem.repository.Userrepo;

@Service
public class Loginserviceimp {

	@Autowired
	private Loginrepo repository;
	@Autowired
	private Userrepo repo;

	public boolean checkLogin(Userlogin login, Userpojo regi) {
		Long userID = login.getUserID();
		String password = login.getPassword();
		if (userID == regi.getUserID()) {
			return true;
		} else {
			return false;
		}

	}

	public ResponseEntity<Object> doLogin(Userpojo login) {
		if (repo.findByUserID(login.getUserID()).isPresent()) {
			return ResponseEntity.ok().body("Login successfull");
		} else {
			return ResponseEntity.badRequest().body("Login failed!!");
		}
	}

}
