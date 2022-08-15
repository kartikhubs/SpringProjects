package com.flightmanage.service;

import java.util.List;

import com.flightmanage.entity.Passenger;

public interface Passengerservicelayer {

	// abstract method
	List<Passenger> getpassdetails(Long bookingid);

}
