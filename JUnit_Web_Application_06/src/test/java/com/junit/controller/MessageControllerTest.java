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

import com.junit.service.MsgService;

@WebMvcTest(controllers = MessageController.class)
public class MessageControllerTest {
	
	@MockBean	//mock object
	private MsgService msgService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testWelcome() throws Exception {
		
		//set the behaviour
		when(msgService.getWelcomeMsg()).thenReturn("Good Morning");
		
		//prepare GET request to /msg/welcome url
		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/msg/welcome");
		
		//send GET request using MockMVC bean
		MvcResult result= mockMvc.perform(request).andReturn();
		
		//get response
		MockHttpServletResponse response= result.getResponse();
		
		//validate the response
		int status=response.getStatus();	
		assertEquals(200, status);
	}
	
	@Test
	public void testGreet() throws Exception {
		//setting behaviour
		when(msgService.getGreetMsg()).thenReturn("Good Afternoon");
		
		//prepare request
		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/msg/greet");
	
		//send request
		MvcResult result= mockMvc.perform(request).andReturn();
		
		//get response
		MockHttpServletResponse response= result.getResponse();
		
		//validate 
		String actual =response.getContentAsString();
		String expected="Good Afternoon";
		assertEquals(actual, expected);
	}

}
