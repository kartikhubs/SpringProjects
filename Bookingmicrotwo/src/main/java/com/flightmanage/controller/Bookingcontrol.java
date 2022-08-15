package com.flightmanage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightmanage.entity.Booking;
import com.flightmanage.service.Bookingservicelayer;

@RestController // consumes web service APIs
@RequestMapping("/book")
public class Bookingcontrol {
	@Autowired
	private Bookingservicelayer bookservice;
	
	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping("/{userid}")
	public List<Booking> getUserdetails(@PathVariable("userid") Long userid) {
		return this.bookservice.getuserdetails(userid);
	}
	

}
