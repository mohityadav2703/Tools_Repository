package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.Student;
import com.redis.repo.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository srepo;
	
	@GetMapping("/students")
	public Iterable<Student> getAllStudents(){
		return srepo.findAll();
	}
	
	@PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        try {
            srepo.save(student);
            return "Student Saved";
        } catch (RedisConnectionFailureException e) {
            return "Error: Unable to connect to Redis. Please check your Redis server.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
