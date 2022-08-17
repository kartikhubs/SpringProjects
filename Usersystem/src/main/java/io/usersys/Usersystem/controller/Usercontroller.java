package io.usersys.Usersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.usersys.Usersystem.entity.Userpojo;
import io.usersys.Usersystem.service.Userserviceimp;

@RestController
@RequestMapping("/user")
public class Usercontroller {
	@Autowired
	private Userserviceimp userservice;
	
	
	
		
	
	
	   @PostMapping("/register")
	   public ResponseEntity<Userpojo>register(@RequestBody Userpojo user) {
		if(userservice.confirmpass(user)==true) {
		  return new ResponseEntity<Userpojo>(userservice.register(user), HttpStatus.CREATED);
	    }
	   
		
		else {
			return new ResponseEntity<Userpojo>(HttpStatus.NOT_FOUND);
			
		}
	   }
}
		


