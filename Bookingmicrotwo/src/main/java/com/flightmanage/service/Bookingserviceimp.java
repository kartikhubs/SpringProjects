package com.flightmanage.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.flightmanage.entity.Booking;

@Service
public class Bookingserviceimp implements Bookingservicelayer {
	// fake booking list
	List<Booking> booklist = List.of(new Booking(1070L, "22-07-2022", 107.8, 9, 1200L),
			new Booking(1071L, "21-06-2015", 300.5, 3, 1201L), new Booking(1072L, "14-12-2020", 600.5, 8, 1202L),
			new Booking(1073L, "12-05-2019", 500.0, 7, 1203L));
	
	
	

	@Override
	public List<Booking> getuserdetails(Long userid) {

		return booklist.stream().filter(x -> x.getUserid().equals(userid)).collect(Collectors.toList());
	}

	
	
}
