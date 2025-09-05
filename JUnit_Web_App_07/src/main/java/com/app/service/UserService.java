package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public String getName(Integer id) {
		
		System.out.println(userDao.getClass().getName());
		return userDao.findName(id);
	}

}
