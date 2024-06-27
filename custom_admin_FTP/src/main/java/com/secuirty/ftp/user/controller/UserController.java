package com.secuirty.ftp.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.secuirty.ftp.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/checkDuplicatedId")
	public ResponseEntity<String> checkDuplicatedId(@RequestParam("userId") String userId)throws Exception{
		
		return new ResponseEntity<String>(userService.checkDuplicatedId(userId), HttpStatus.OK);
		
	}
	
}
