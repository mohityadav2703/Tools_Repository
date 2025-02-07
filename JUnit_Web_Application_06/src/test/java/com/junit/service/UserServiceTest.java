package com.junit.service;

import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.junit.dao.UserDao;
import com.junit.model.User;

@SpringBootTest
public class UserServiceTest {
	
	@MockitoBean
	private UserDao userDao;
	
	@InjectMocks
	private UserService userService;
	
	public void saveUserTest() {
		User user = new User();
		user.setId(101);
		user.setName("Mohit Kumar");
		user.setEmail("abc@gmail.com");
		
		
	}
	
}
