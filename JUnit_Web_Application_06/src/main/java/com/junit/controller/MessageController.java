package com.junit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.service.MsgService;

@RestController
@RequestMapping("/msg")
public class MessageController {
	
	@Autowired
	private MsgService messageService;
	
	@GetMapping("/welcome")
	public String getWelcome() {
		return messageService.getWelcomeMsg();
	}
	
	@GetMapping("/greet")
	public String getGreet() {
		return messageService.getGreetMsg();
	}

}
