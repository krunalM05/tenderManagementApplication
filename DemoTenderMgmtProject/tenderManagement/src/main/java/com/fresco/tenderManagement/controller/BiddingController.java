package com.fresco.tenderManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fresco.tenderManagement.model.BiddingModel;
import com.fresco.tenderManagement.service.BiddingService;

@RestController
@RequestMapping("/bidding")
public class BiddingController {
	
	@Autowired
	private BiddingService biddingService;
	
	// to create bidding using bidding object
	
	@PostMapping("/add")
	public ResponseEntity<Object> postBidding(BiddingModel biddingModel){
		return null;
	}
	
	// to get the bidding by id as pathvarible
	
	public ResponseEntity<Object> getBidding( int id){
		return null;
	}
	
	//to update the bidding by id as pathvariable and bidding object
	
	@PutMapping("/update/{id}") 
	public ResponseEntity<Object> updateBidding( int id, BiddingModel biddingModel){
		return null;
	}
	
	// to delete bidding by using id as pathvarible
	public ResponseEntity<Object> deleteBidding( int id){
		return null;
	}

}
