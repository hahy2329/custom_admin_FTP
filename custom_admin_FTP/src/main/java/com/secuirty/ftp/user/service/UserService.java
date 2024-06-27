package com.secuirty.ftp.user.service;

import com.secuirty.ftp.user.dto.UserDTO;

public interface UserService {
	
	public String checkDuplicatedId(String userId) throws Exception;
	public void userRegister(UserDTO userDTO) throws Exception;
}
