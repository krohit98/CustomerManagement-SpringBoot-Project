package com.cg.apps.customermgt.itemms.service;

import com.cg.apps.customermgt.itemms.entities.Item;

public interface IItemService {

	Item create(double price, String description);
	Item findById(String itemId);
	Item buyItem(String itemId, Long customerId);
}
