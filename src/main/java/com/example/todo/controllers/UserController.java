package com.example.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.models.User;
import com.example.todo.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public void createUser(@RequestBody String name, @RequestBody String email, @RequestBody String password ) {

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		userService.createUser(user);
		
	}
	
}
