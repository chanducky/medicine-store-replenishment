package com.cky.medstores.util;

import com.cky.medstores.model.StoreInventory;

/**
 * @author chandrakumar
 *
 */
public class AppUtil {
	// method does not calculate actual distance between two point,this can be used for sorting only  
	public static Integer getDistanceBetweenStores(StoreInventory s1,StoreInventory s2){
		return Math.abs(s1.getxCordinate()-s2.getxCordinate()) + Math.abs(s1.getyCordinate()-s2.getyCordinate());
	}
}
