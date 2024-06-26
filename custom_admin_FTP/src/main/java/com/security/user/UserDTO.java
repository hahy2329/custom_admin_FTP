package com.security.user;

import lombok.Data;

@Data
public class UserDTO {
	
	private String userId;
	private String userName;
	private String password;
	private int enabled;
	
}
