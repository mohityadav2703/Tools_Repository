package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.Student;
import com.redis.repo.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return "Student Saved";
	}

	@GetMapping("/students")
	public Iterable<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
}
