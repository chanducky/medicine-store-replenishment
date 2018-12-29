package com.cky.medstores.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cky.medstores.model.StoreInventory;
import com.cky.medstores.repository.StoreInventoryRepository;
import com.cky.medstores.util.AppUtil;

/**
 * @author chandrakumar
 *
 */
@Service
public class StoreServiceImpl implements StoreService {

	private StoreInventoryRepository storeInventoryRepository;
	
	public StoreServiceImpl(StoreInventoryRepository storeInventoryRepository) {
		super();
		this.storeInventoryRepository = storeInventoryRepository;
	}

	@Override
	public List<StoreInventory> findNearestServingStore(StoreInventory requestingStore,Integer distance,Integer quantity) {
		
		Collection<StoreInventory> stores= this.storeInventoryRepository.findServingStores(requestingStore.getStoreId(),requestingStore.getxCordinate(),requestingStore.getyCordinate(),distance, quantity);
		
		List<StoreInventory> sortedStores = stores.stream().sorted((s1,s2)-> AppUtil.getDistanceBetweenStores(s1, requestingStore).compareTo(AppUtil.getDistanceBetweenStores(s2, requestingStore))).collect(Collectors.toList());
		
		return sortedStores;
	}
	
}
