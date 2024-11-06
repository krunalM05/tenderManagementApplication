package com.fresco.tenderManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresco.tenderManagement.model.UserModel;

@Repository
public 	interface UserRepository extends JpaRepository<UserModel, Integer>{

	Optional<UserModel> findByEmail(String email);

}
