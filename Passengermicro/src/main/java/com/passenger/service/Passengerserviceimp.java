package com.passenger.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.passenger.entity.Passenger;

@Service
public class Passengerserviceimp implements Passengerservicelayer {

	List<Passenger> list = List.of(new Passenger(12L, "KARTIK NEWLAY", 22, 123, 1070L),
			new Passenger(13L, "MAYANK DUBEY", 21, 124, 1071L));

	@Override
	public List<Passenger> getpassdetails(Long bookingid) {

		return list.stream().filter(x -> x.getBookingid().equals(bookingid)).collect(Collectors.toList());
	}

}
