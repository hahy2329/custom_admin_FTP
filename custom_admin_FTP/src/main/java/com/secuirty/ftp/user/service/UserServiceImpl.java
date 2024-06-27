package com.secuirty.ftp.user.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.secuirty.ftp.user.dao.UserDAO;
import com.secuirty.ftp.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public String checkDuplicatedId(String userId) throws Exception {
		if(userDAO.checkDuplicatedId(userId) == null) {
			return "NotDuplicate";
		}else {
			return "Duplicate";
		}
		
	}

	@Override
	public void userRegister(UserDTO userDTO) throws Exception {
		userDTO.setPassword(bcryptPasswordEncoder.encode(userDTO.getPassword())); //패스워드 인코딩작업 후 재적재.
		userDTO.setEnabled(1);
		
		userDAO.userRegister(userDTO);
		
	}
	
}
