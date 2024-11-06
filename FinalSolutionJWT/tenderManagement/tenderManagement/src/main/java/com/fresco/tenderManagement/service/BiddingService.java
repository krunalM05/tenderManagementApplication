package com.fresco.tenderManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		
		BiddingModel model = new BiddingModel(biddingModel.getBiddingId(), biddingModel.getBidAmount(),
				biddingModel.getYearsToComplete(), biddingModel.getDateOfBidding(), biddingModel.getBidderId());
		try {
			biddingRepository.save(model);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
	}
	
	//to get bidding details which are greater than the given bidAmount 
	// ok 200
	// badRequest 400
	
	public ResponseEntity<Object> getBidding(double bidAmount){
		Optional<List<BiddingModel>> modelList = biddingRepository.findByBidAmountGreaterThan(bidAmount);
		
		if(!modelList.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(modelList.get());
			
	}
	
	//to update bidding status
	//ok 200
	// badrequest 400
	
	public ResponseEntity<Object> updateBidding(int id, BiddingModel biddingModel){
		Optional<BiddingModel> optionalModel = biddingRepository.findById(id);
		
		if(!optionalModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		BiddingModel model = optionalModel.get();
		model.setStatus(biddingModel.getStatus());
		
		return ResponseEntity.status(HttpStatus.OK).body(model);
		
	}
	
	//to delete the bidding by using id
	// approver and only the creater of that perticular bidding can delete
	// no content 204
	// badrequest 400
	// forbidden 403
	
	public ResponseEntity<Object> deleteBidding(int id){
		Optional<BiddingModel> model = biddingRepository.findById(id);
		
		if(!model.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		try {
			biddingRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted Successfully!");
		
	}
	
}
