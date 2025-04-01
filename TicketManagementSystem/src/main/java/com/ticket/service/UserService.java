package com.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.entity.User;
import com.ticket.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(@Valid User user) {
    	System.out.println("&&&&&&&&&"+user.getEmail());
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
    	System.out.println("Email=====>"+email);
    	User u=userRepository.findByEmailAndPassword(email, password);
    	System.out.println("#######"+u.getUsername());
    	return u;
       
    }
}
