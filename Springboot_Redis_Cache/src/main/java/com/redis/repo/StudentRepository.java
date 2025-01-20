package com.redis.repo;

import org.springframework.data.repository.CrudRepository;

import com.redis.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
