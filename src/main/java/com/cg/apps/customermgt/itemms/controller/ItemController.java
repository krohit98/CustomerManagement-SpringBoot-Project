package com.cg.apps.customermgt.itemms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.customermgt.itemms.dto.BuyItemRequest;
import com.cg.apps.customermgt.itemms.dto.ItemDetails;
import com.cg.apps.customermgt.itemms.entities.Item;
import com.cg.apps.customermgt.itemms.service.IItemService;
import com.cg.apps.customermgt.itemms.util.ItemUtil;

@RequestMapping("/items")
@RestController
public class ItemController {

	@Autowired
	IItemService service;
	
	@Autowired
	ItemUtil util;
	
	@GetMapping(value = "/itembyid/{id}")
	public ItemDetails fetchitems(@PathVariable("id") String itemId) {
		ItemDetails details = util.toDetails(service.findById(itemId));
		return details;
	}
	
	@PutMapping("/buyitem")
	public ItemDetails buyitems(@RequestBody BuyItemRequest requestData) {
		Item item = service.buyItem(requestData.getItemId(), requestData.getCustomerId());
		ItemDetails details = util.toDetails(item);
		return details;
	}
}
