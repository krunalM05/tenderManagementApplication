package com.fresco.tenderManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Object> postBidding(@RequestBody BiddingModel biddingModel){
		return biddingService.postBidding(biddingModel);
	}
	
	// to get the biddings which are greater than bidding amount
	@GetMapping("/list")
	public ResponseEntity<Object> getBidding(@RequestParam double bidAmount){
		return biddingService.getBidding(bidAmount);
	}
	
	//to update the bidding by id as pathvariable and bidding object
	
	@PutMapping("/update/{id}") 
	public ResponseEntity<Object> updateBidding(@PathVariable int id,@RequestBody BiddingModel biddingModel){
		return biddingService.updateBidding(id, biddingModel);
	}
	
	// to delete bidding by using id as pathvarible
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteBidding(@PathVariable int id){
		return biddingService.deleteBidding(id);
	}

}
