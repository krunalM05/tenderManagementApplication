package com.fresco.tenderManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fresco.tenderManagement.dto.LoginDTO;
import com.fresco.tenderManagement.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public Object authenticateUser(@RequestBody LoginDTO loginDTO) throws Exception{
		return loginService.doAuthenticateUser(loginDTO);
	}
	
}
