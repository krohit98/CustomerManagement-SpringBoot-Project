package com.cg.apps.customermgt.customerms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.customermgt.customerms.dto.AddAmountRequest;
import com.cg.apps.customermgt.customerms.dto.CustomerDetails;
import com.cg.apps.customermgt.customerms.dto.GetItemsBoughtRequest;
import com.cg.apps.customermgt.customerms.entities.Customer;
import com.cg.apps.customermgt.customerms.service.ICustomerService;
import com.cg.apps.customermgt.customerms.util.CustomerUtil;

@RequestMapping("/customers")
@RestController
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerUtil util;
	
	@GetMapping(value = "/byid/{id}")
	public CustomerDetails fetchCustomer(@PathVariable("id") Long customerId){
		
		Customer customer = service.findByID(customerId);
		CustomerDetails details = util.customerDetailsById(customer);
		return details;
				
	}
	
	@PutMapping("/addamount")
	public CustomerDetails addAmount(@RequestBody AddAmountRequest requestData) {
	
		Customer customer = service.addAmount(requestData.getCustomerId(), requestData.getAmount());
		CustomerDetails details = util.customerDetailsById(customer);
		return details;
		
	}
	
	@GetMapping(value = "/getitemsbought/{id}")
	public List<GetItemsBoughtRequest> getitemsBought(@PathVariable("id") Long customerId){
		
		Customer customer = service.findByID(customerId);
		List<GetItemsBoughtRequest> itemList = util.getItemList(customer.getBoughtItems());
		return itemList;
	}
}
