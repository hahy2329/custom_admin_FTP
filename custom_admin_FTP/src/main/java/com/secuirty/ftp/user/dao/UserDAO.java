package com.secuirty.ftp.user.dao;

public interface UserDAO {
	
	public String checkDuplicatedId(String userId) throws Exception;
}
