package com.cg.apps.customermgt.itemms.dto;

public class BuyItemRequest {

	private String itemId;
	private Long customerId;
	
	public BuyItemRequest() {}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	
}
