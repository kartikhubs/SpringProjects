package io.usersys.Usersystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.usersys.Usersystem.entity.Userpojo;

@Repository 
public interface Userrepo extends JpaRepository<Userpojo, Long> {

	Optional<Userpojo> findByUserID(Long userID);
	
}
