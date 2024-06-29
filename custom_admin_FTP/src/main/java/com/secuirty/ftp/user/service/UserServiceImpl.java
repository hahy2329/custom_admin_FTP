package com.secuirty.ftp.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.secuirty.ftp.user.dao.UserDAO;
import com.secuirty.ftp.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
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
		String bcrypt = "{bcrypt}"; // 스프링 시큐리티 적용 후 회원가입 시 비밀번호는 Bcrypt 해시 함수로 암호화 하기에 스프링 시큐리티가 인증할 수 있도록 사용자 패스워드에  {bcrypt} + 패스워드로 저장
		
		userDTO.setPassword(bcrypt+bcryptPasswordEncoder.encode(userDTO.getPassword())); //패스워드 인코딩작업 후 재적재.
		userDTO.setEnabled(1);
		
		logger.info(userDTO.getPassword());
		
		userDAO.userRegister(userDTO); // user 회원가입
		userDAO.userAuthorities(userDTO); // user 권한 설정('ROLE_USER') ※ 관리자는 'ROLE_ADMIN'
		userDAO.userGroupMember(userDTO); // user 그룹 설정('사용자 그룹')   ※ 관리자는 'ROLE_ADMIN'
		
	}
	
}
