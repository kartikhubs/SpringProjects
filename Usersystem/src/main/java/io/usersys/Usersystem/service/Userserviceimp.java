package io.usersys.Usersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.usersys.Usersystem.entity.Userpojo;
import io.usersys.Usersystem.repository.Userrepo;

@Service
public class Userserviceimp{

	@Autowired
	private Userrepo repository;

	
	public Userpojo register(Userpojo user) {
		
		return repository.save(user);
	}

	
	public boolean confirmpass(Userpojo user){
		
		String pass=user.getPassword();
		String passtwo=user.getConfirmPassword();
		if(pass.equals(passtwo)) {
			return true;
		}
		else {
			System.out.println("Passwords do not match");
			return false;
		}
		
	}


	public Userpojo login(Userpojo user) {
		
		
		
	}

	
	public Userpojo logout(Userpojo user) {
		
		return null;
	}

}
