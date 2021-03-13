package com.cg.apps.customermgt.itemms.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.customermgt.itemms.entities.Item;
import com.cg.apps.customermgt.itemms.service.IItemService;

@Component
public class ItemUI {

	@Autowired
	IItemService service;
	
	public void start() {
		
		Item item1 = service.create(7000, "Redmi Note 7");
		Item item2 = service.create(10000, "Redmi Note 7 Pro");
		Item item3 = service.create(15000, "Iphone 11");
		
		Item fetchedItem1 = service.findById(item1.getId());
		Item fetchedItem2 = service.findById(item2.getId());
		Item fetchedItem3 = service.findById(item3.getId());
		
		System.out.println("\n***Item Details***\n");
		
		display(fetchedItem1);
		display(fetchedItem2);
		display(fetchedItem3);
		
	}
	
	
	public void display(Item item) {
		
		System.out.println("ItemID: "+item.getId()
							+"\nItem Price: "+item.getPrice()
							+"\nItem description: "+item.getDescription()
							+"\nItem added on: "+item.getAddedDate()
							+"\n");
	}
}
