package com.cg.apps.customermgt.customerms.dto;

public class GetItemsBoughtRequest {

	private String id;
	private double price;
	
	public GetItemsBoughtRequest() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
