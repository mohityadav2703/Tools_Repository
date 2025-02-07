package com.junit.service;

import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class CustomerServiceTest {
	
	@InjectMocks
	private CustomerService customerService;

}
