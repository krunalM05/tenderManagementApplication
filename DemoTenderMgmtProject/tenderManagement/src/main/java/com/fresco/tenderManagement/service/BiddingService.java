package com.fresco.tenderManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fresco.tenderManagement.model.BiddingModel;
import com.fresco.tenderManagement.repository.BiddingRepository;

@Service
public class BiddingService {

	@Autowired
	private BiddingRepository biddingRepository;
	
	@Autowired
	private UserService userService;
	
	//to add the Bidding using Bidding Object 
	//created 201
	//badRequest 400
	
	public ResponseEntity<Object> postBidding(BiddingModel biddingModel){
		return null;
	}
	
	//to get bidding details which are greater than the given bidAmount 
	// ok 200
	// badRequest 400
	
	public ResponseEntity<Object> getBidding(double bidAmount){
		return null;
	}
	
	//to update bidding status
	//ok 200
	// badrequest 400
	
	public ResponseEntity<Object> updateBidding(int id, BiddingModel biddingModel){
		return null;
	}
	
	//to delete the bidding by using id
	// approver and only the creater of that perticular bidding can delete
	// no content 204
	// badrequest 400
	// forbidden 403
	
	public ResponseEntity<Object> deleteBidding(int id){
		return null;
	}
	
}
