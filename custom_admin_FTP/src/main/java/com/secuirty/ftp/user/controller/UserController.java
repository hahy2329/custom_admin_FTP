package com.secuirty.ftp.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.secuirty.ftp.user.dto.UserDTO;
import com.secuirty.ftp.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/register")
	public String register() {
		return "user/register";
	}
	
	
	@GetMapping("/checkDuplicatedId")
	public ResponseEntity<String> checkDuplicatedId(@RequestParam("userId") String userId) throws Exception{
		
		return new ResponseEntity<String>(userService.checkDuplicatedId(userId), HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> userRegister(@ModelAttribute UserDTO userDTO, HttpServletRequest request) throws Exception{
		
		userService.userRegister(userDTO);
		
		String message = "<script>";
		message += "alert('회원가입 완료!');";
		message += "location.href='" + request.getContextPath() + "/';";
		message += "</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
}
