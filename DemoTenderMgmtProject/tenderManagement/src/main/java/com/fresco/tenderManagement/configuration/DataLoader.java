package com.fresco.tenderManagement.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fresco.tenderManagement.model.RoleModel;
import com.fresco.tenderManagement.model.UserModel;
import com.fresco.tenderManagement.repository.RoleRepository;
import com.fresco.tenderManagement.repository.UserRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		roleRepository.save(new RoleModel("BIDDER"));
		roleRepository.save(new RoleModel("APPROVER"));
		
		userRepository.save(new UserModel(1, "bidder1","companyOne","bidder123$","bidder1@gmail.com",new RoleModel(1)));
		userRepository.save(new UserModel(2, "bidder2","companyTwo","bidder456$","bidder2@gmail.com",new RoleModel(1)));
		userRepository.save(new UserModel(3, "bidder1","companyThree","bidder789$","bidder3@gmail.com",new RoleModel(2)));
		
	}

}
