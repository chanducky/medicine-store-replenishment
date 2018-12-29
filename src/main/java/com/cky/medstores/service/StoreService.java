package com.cky.medstores.service;

import java.util.List;

import com.cky.medstores.model.StoreInventory;


/**
 * @author chandrakumar
 *
 */
public interface StoreService {
	
	public List<StoreInventory> findNearestServingStore(StoreInventory requestingStore,Integer distance,Integer quantity) ;
}
