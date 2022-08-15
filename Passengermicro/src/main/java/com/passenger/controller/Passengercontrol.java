package com.passenger.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.passenger.entity.Passenger;
import com.passenger.service.Passengerservicelayer;

@RestController // consumes web service APIs
@RequestMapping("/product")
public class Passengercontrol {
	@Autowired
	private Passengerservicelayer productservice;

	@RequestMapping("/orderit/{bookingid}")
	public List<Passenger> getProductdetails(@PathVariable("bookingid") Long bookingid) {
		return this.productservice.getpassdetails(bookingid);
	}

}
