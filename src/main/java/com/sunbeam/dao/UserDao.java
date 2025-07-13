package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.User;

public interface UserDao extends JpaRepository<User, Long> {

	// derived method
	Optional<User> findByEmailAndPassword(String email, String password);
	//derived finder
	boolean existsByEmail(String email);
	//derived finder
	List<User> findByMyAddressCity(String city);
}
