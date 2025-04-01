package com.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.entity.User;

public interface UserRepository  extends JpaRepository<User,Integer>{
	 User findByEmail(String email);
	User  findByEmailAndPassword(String userEmail, String userPassword);
}