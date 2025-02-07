package com.junit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.junit.service.UserService;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
	
	@MockBean()
	private UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getUser() throws Exception {
		
		//set the behaviour
		when(userService.getName(101)).thenReturn("Hello Welcome");
		
		//prepare request
		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/user/details");
		
		//send Get request 
		MvcResult result= mockMvc.perform(request).andReturn();
		
		//get response
		MockHttpServletResponse response = result.getResponse();
		
		//validate
		String actual= response.getContentAsString();
		String expected = "Hello Welcome";
		assertEquals(actual, expected);
		
	}

}
