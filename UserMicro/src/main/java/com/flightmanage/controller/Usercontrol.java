package com.flightmanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightmanage.common.Booking;
import com.flightmanage.entity.User;
import com.flightmanage.service.Userservicelayer;

@RestController // used for making webservices used by client
@RequestMapping("/user")
public class Usercontrol {

	@Autowired //
	private Userservicelayer userservice;

	@Autowired
	public RestTemplate restTemplate; // create application that consume RESTful webservices

	@GetMapping("/{userid}") // userid
	public User getUser(@PathVariable("userid") Long userid) {

		User user = this.userservice.getuser(userid);

		// connecting User service and booking service via path
		List bookings = this.restTemplate.getForObject("http://localhost:4002/book/" + user.getUserid(), List.class);

		user.setBookingdetails(bookings);

		return user;
	}

}
