package com.fresco.tenderManagement.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder passEncoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		RoleModel bidderRole = new RoleModel("BIDDER");
		RoleModel approverRole = new RoleModel("APPROVER");
		roleRepository.save(bidderRole);
		roleRepository.save(approverRole);
		
		userRepository.save(new UserModel(1, "bidder1","companyOne",passEncoder.encode("bidder123$"),
				"bidder1@gmail.com",bidderRole));
		userRepository.save(new UserModel(2, "bidder2","companyTwo",passEncoder.encode("bidder456$"),
				"bidder2@gmail.com",bidderRole));
		userRepository.save(new UserModel(3, "bidder3","companyThree",passEncoder.encode("approver789$"),
				"approver@gmail.com",approverRole));
		
	}

}