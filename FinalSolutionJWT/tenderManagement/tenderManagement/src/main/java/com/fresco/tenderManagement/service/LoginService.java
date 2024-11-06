package com.fresco.tenderManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.fresco.tenderManagement.dto.LoginDTO;
import com.fresco.tenderManagement.dto.LoginResponse;
import com.fresco.tenderManagement.model.UserModel;
import com.fresco.tenderManagement.repository.UserRepository;
import com.fresco.tenderManagement.security.JWTUtil;

@Service
public class LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	public Object doAuthenticateUser(LoginDTO loginDTO) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
		UserModel authenticatedUser = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow();
		String token = jwtUtil.generateToken(authenticatedUser);
		LoginResponse response = new LoginResponse();
		response.setToken(token);
		response.setExpirationTime(jwtUtil.getJwtExpiration());
		return ResponseEntity.ok(response);
	}

}
