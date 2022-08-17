package io.usersys.Usersystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.usersys.Usersystem.entity.Userlogin;
import io.usersys.Usersystem.entity.Userpojo;

public interface Loginrepo extends JpaRepository<Userlogin, Long> {

	

	
}
