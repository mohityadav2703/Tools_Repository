package com.app.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerRestController {
	
	@GetMapping("/")
	public String getMsg() {
		return "Welcome to Springboot Application Using Dockerfile...!!!";
	}

}
