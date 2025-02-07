package com.junit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junit.model.Customer;
import com.junit.service.CustomerService;

@WebMvcTest(controllers = CustomerRestController.class)
public class CustomerRestControllerTest {
	
	@MockBean
	private CustomerService customerService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void saveCustomerTest_Tc_01() throws Exception {
		Customer c = new Customer();
		c.setId(101);
		c.setName("Mohit Kumar");
		c.setEmail("mohit.au001@gmail.com");
	
		//set the behaviour
		when(customerService.saveCustomer(any())).thenReturn(true);
	
		//convert object to json
		ObjectMapper mapper = new ObjectMapper();
		String customerJson=mapper.writeValueAsString(c);
			
		//prepare the request
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/customer/save").content(customerJson).contentType("application/json");
		
		//send post request
		MvcResult result=mockMvc.perform(req).andReturn();
		
		//get response
		MockHttpServletResponse response= result.getResponse();
		
		int actual = response.getStatus();
		int expected=201;
		assertEquals(actual, expected);
	}
	
	@Test
	public void saveCustomerTest_Tc_02() throws Exception {
		Customer c = new Customer();
		c.setId(101);
		c.setName("Mohit Kumar");
		c.setEmail("mohit.au001@gmail.com");
	
		//set the behaviour
		when(customerService.saveCustomer(any())).thenReturn(false);
	
		//convert object to json
		ObjectMapper mapper = new ObjectMapper();
		String customerJson=mapper.writeValueAsString(c);
			
		//prepare the request
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/customer/save").content(customerJson).contentType("application/json");
		
		//send post request
		MvcResult result=mockMvc.perform(req).andReturn();
		
		//get response
		MockHttpServletResponse response= result.getResponse();
		
		int actual = response.getStatus();
		int expected=500;
		assertEquals(actual, expected);
	}
}
