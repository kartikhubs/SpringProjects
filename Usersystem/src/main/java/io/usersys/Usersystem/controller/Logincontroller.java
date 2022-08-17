package io.usersys.Usersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.usersys.Usersystem.entity.Userlogin;
import io.usersys.Usersystem.entity.Userpojo;
import io.usersys.Usersystem.service.Loginserviceimp;

@RestController 
@RequestMapping("/cred")
public class Logincontroller {

	@Autowired
	private Loginserviceimp loginservice;

	@GetMapping("/create")
	public ResponseEntity<Object> doLogin(@RequestBody Userpojo login) {
		
			return loginservice.doLogin(login);
		} 
	}


