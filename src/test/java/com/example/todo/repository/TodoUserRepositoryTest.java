package com.example.todo.repository;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.todo.models.User;

@DataJpaTest
public class TodoUserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	@DisplayName("Test for saving new user")
	public void testSaveUser() {
		
		User user = new User();
		user.setName("Test User1");
		user.setEmail("testemail1@email.com");
		user.setPassword("test_password_1");
		
		User savedUser = userRepository.save(user);
		
		assertThat(savedUser.getId()).isNotNull();
		assertThat(savedUser.getName()).isEqualTo("Test User1");
		assertThat(savedUser.getEmail()).isEqualTo("testemail1@email.com");
		
	}
	
//	@Test
//	@DisplayName("Test for retrieving name from email address")
//	public void testGetNameByEmail() {
//		
//		User getUser = userRepository.findByEmail("testemail1@email.com");
//		
//		assertThat(getUser.getName()).isEqualTo("Test User1");
//		
//	}
//	
//	@Test
//	@DisplayName("Test for deleting the user")
//	public void testDeleteUser() {
//		
//		userRepository.deleteUserByEmail("testemail1@email.com");
//		
//		User deletedUser = userRepository.findByEmail("testemail1@email.com");
//		
//		assertThat(deletedUser.getId()).isNull();
//		
//	}
}
