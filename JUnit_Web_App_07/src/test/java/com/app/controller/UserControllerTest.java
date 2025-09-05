package com.app.controller;

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

import com.app.service.UserService;

@WebMvcTest(controllers=UserController.class)
public class UserControllerTest {
	
	@MockBean()
	private UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void getUser() throws Exception {
		
		when(userService.getName(101)).thenReturn("Hello World");
		
		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/user/details");
		
		MvcResult result= mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		String actual=response.getContentAsString();
		String expected="Hello World";
		
		assertEquals(actual, expected);
	}

}
