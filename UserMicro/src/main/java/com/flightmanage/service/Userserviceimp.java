package com.flightmanage.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flightmanage.entity.User;

@Service
public class Userserviceimp implements Userservicelayer {

	// fake user list
	List<User> userlist = List.of(new User("Admin", 1200L, "Ramesh", "hello123", 717162673L, "ramesh@gmail.com"),
			new User("Customer", 1201L, "Suresh", "global@123", 9131087406L, "suresh@gl.com"),
			new User("Admin", 1202L, "Tushyap", "flexi123", 7387382837L, "tushyap@gl.com"),
			new User("Customer", 1203L, "Karishma", "hello!@#", 7464637736L, "karishma@yahoo.com"));

	public User getuser(Long userid) {

		// lambda expression
		return userlist.stream().filter(x -> x.getUserid().equals(userid)).findAny().orElse(null);

	}

}
