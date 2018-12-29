package com.cky.medstores.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cky.medstores.exception.BadRequestException;
import com.cky.medstores.model.StoreInventory;
import com.cky.medstores.model.response.ResponseSuccessMessage;
import com.cky.medstores.repository.StoreInventoryRepository;
import com.cky.medstores.service.StoreService;

/**
 * @author chandrakumar
 *
 */
@RestController
@RequestMapping("/v1/stores")
public class StoreController {

	private StoreInventoryRepository storeInventoryRepository;
	private StoreService storeService;
	
	public StoreController(StoreInventoryRepository storeInventoryRepository, StoreService storeService) {
		super();
		this.storeInventoryRepository = storeInventoryRepository;
		this.storeService = storeService;
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<Object>(new ResponseSuccessMessage(HttpStatus.OK, storeInventoryRepository.findAll()),HttpStatus.OK);
	}
	
	@GetMapping("/{storeid}")
	public ResponseEntity<Object> findByStoreId(@PathVariable(required=true)String storeid) {
		return new ResponseEntity<Object>(new ResponseSuccessMessage(HttpStatus.OK, storeInventoryRepository.findByStoreId(storeid)),HttpStatus.OK);
	}
	
	@GetMapping("/{storeid}/restock")
	public ResponseEntity<Object> findServingStoreForRestock(@PathVariable(required=true)String storeid,@RequestParam(required=true)Integer distance,@RequestParam(required=true)Integer quantity) {
		StoreInventory requestingStore =  storeInventoryRepository.findByStoreId(storeid.trim());
		if(requestingStore==null){
			throw new BadRequestException("Store with store id "+storeid+" does not exist.");
		}else if(distance<=0){
			throw new BadRequestException("Invalid value of parameter distance.");
		}
		else if(quantity<=0){
			throw new BadRequestException("Invalid value of parameter quantity.");
		}
		
		List<StoreInventory> servingStores=this.storeService.findNearestServingStore(requestingStore, distance, quantity);
		
		return new ResponseEntity<Object>(new ResponseSuccessMessage(HttpStatus.OK,servingStores),HttpStatus.OK);
	}
}
