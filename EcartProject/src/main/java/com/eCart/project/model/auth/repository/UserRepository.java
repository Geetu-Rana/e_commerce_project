package com.eCart.project.model.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eCart.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String email);
	public Optional<User>  findByPhoneNumber(String phoneNumber);
	public Boolean existsByEmail(String email);
	
}
