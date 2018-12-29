package com.cky.medstores.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author chandrakumar
 *
 */
@Entity
@Table(name="inventory")
public class StoreInventory {
	@Id
	private String storeId;
	private Integer xCordinate;
	private Integer yCordinate;
	private Integer currentInventoryLevel;
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public Integer getxCordinate() {
		return xCordinate;
	}
	public void setxCordinate(Integer xCordinate) {
		this.xCordinate = xCordinate;
	}
	public Integer getyCordinate() {
		return yCordinate;
	}
	public void setyCordinate(Integer yCordinate) {
		this.yCordinate = yCordinate;
	}
	public Integer getCurrentInventoryLevel() {
		return currentInventoryLevel;
	}
	public void setCurrentInventoryLevel(Integer currentInventoryLevel) {
		this.currentInventoryLevel = currentInventoryLevel;
	}
	@Override
	public String toString() {
		return "StoreInventory [storeId=" + storeId + ", xCordinate=" + xCordinate + ", yCordinate=" + yCordinate
				+ ", currentInventoryLevel=" + currentInventoryLevel + "]";
	}
	
	
}
