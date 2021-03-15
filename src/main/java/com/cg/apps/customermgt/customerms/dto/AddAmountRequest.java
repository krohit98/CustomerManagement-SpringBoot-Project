package com.cg.apps.customermgt.customerms.dto;

public class AddAmountRequest {

	private Long customerId;
	private double amount;
	
	public AddAmountRequest() {}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
