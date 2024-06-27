package com.secuirty.ftp.user.dto;

import lombok.Data;

@Data
public class UserDTO {
	
	private String userId;
	private String userName;
	private String password;
	private int enabled;
	
}
