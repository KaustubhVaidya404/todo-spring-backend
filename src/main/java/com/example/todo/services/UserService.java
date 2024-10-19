package com.example.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.User;
import com.example.todo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public boolean createUser(User user) {
		try {
			User receivedUser = userRepository.findByEmail(user.getEmail());
			if (receivedUser.getEmail() == null) {
				userRepository.save(user);
				return true;
			} else {
				return false;
			}
		} catch (Error e) {
			return false;
		}
	}
	
}
