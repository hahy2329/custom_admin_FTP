package com.secuirty.ftp.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.secuirty.ftp.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	private SqlSession sqlSession;
	
	@Override
	public String checkDuplicatedId(String userId) throws Exception {
		return sqlSession.selectOne("user.checkDuplicatedId", userId);
	}

	@Override
	public void userRegister(UserDTO userDTO) throws Exception {
		sqlSession.insert("user.userRegister", userDTO);
		
	}

}
