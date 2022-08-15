package com.passenger.service;

import java.util.List;
import com.passenger.entity.Passenger;

public interface Passengerservicelayer {

	// abstract method
	List<Passenger> getpassdetails(Long bookingid);

}
