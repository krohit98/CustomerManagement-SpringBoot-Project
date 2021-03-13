package com.cg.apps.customermgt.itemms.dao;

import com.cg.apps.customermgt.itemms.entities.Item;

public interface IItemDao {

	Item add(Item item);
	Item update(Item item);
	Item findById(String itemId);
	
}
