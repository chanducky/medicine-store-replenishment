package com.cky.medstores.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cky.medstores.model.StoreInventory;

/**
 * @author chandrakumar
 *
 */
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long> {
	
	StoreInventory findByStoreId(String storeid);
	
	@Query("SELECT inv FROM StoreInventory inv WHERE inv.storeId <> :storeId and ABS(inv.xCordinate-:xCordinateRequestingStore)< :distance and ABS(inv.yCordinate-:yCordinateRequestingStore)< :distance and currentInventoryLevel >= :drugQuantity")
	Collection<StoreInventory>  findServingStores(@Param("storeId") String storeId,@Param("xCordinateRequestingStore") Integer xCordinateRequestingStore,
			@Param("yCordinateRequestingStore") Integer yCordinateRequestingStore,@Param("distance") Integer distance, @Param("drugQuantity") Integer drugQuantity);
	
}
