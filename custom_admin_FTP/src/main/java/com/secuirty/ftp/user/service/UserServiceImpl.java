package com.secuirty.ftp.user.service;

import org.springframework.stereotype.Service;

import com.secuirty.ftp.user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	
	@Override
	public String checkDuplicatedId(String userId) throws Exception {
		return userDAO.checkDuplicatedId(userId);
	}
	
}
