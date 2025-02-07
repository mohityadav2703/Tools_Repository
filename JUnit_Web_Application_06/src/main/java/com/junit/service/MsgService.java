package com.junit.service;

import org.springframework.stereotype.Service;

@Service
public class MsgService {
	
	public String getWelcomeMsg() {
		return "Good Morning";
	}
	
	public String getGreetMsg() {
		return "Good Afternoon";
	}

}
