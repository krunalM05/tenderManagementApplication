package com.fresco.tenderManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fresco.tenderManagement.model.UserModel;
import com.fresco.tenderManagement.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<UserModel> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
