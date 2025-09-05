package com.app.dao.impl;

import org.springframework.stereotype.Repository;

import com.app.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public String findName(Integer id) {
		
		return "Nihit Kumar".toUpperCase();
	}

}
