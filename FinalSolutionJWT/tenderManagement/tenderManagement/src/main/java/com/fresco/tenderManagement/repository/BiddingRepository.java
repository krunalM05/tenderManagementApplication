package com.fresco.tenderManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresco.tenderManagement.model.BiddingModel;

@Repository
public interface BiddingRepository extends JpaRepository<BiddingModel, Integer>{
	
	Optional<List<BiddingModel>> findByBidAmountGreaterThan(double bidAmount); 

}
