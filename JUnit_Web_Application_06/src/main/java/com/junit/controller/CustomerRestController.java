package com.junit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.model.Customer;
import com.junit.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
		boolean status =customerService.saveCustomer(customer);
		if(status) {
			sendEmail();
			return new ResponseEntity<String>("Customer Saved...", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Customer Not Saved...",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public void sendEmail() {
		//logic
	}

}
