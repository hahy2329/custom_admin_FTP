package com.secuirty.ftp.user.dao;

import com.secuirty.ftp.user.dto.UserDTO;

public interface UserDAO {
	
	public String checkDuplicatedId(String userId) throws Exception;
	public void userRegister(UserDTO userDTO) throws Exception;
	public void userAuthorities(UserDTO userDTO) throws Exception;
	public void userGroupMember(UserDTO userDTO) throws Exception;
}
