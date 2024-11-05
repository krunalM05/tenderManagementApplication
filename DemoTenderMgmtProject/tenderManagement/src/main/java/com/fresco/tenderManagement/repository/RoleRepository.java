package com.fresco.tenderManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresco.tenderManagement.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer>{

}
