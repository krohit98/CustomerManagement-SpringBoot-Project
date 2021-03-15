package com.cg.apps.customermgt.itemms.util;

import org.springframework.stereotype.Component;

import com.cg.apps.customermgt.itemms.dto.ItemDetails;
import com.cg.apps.customermgt.itemms.entities.Item;

@Component
public class ItemUtil {

	public ItemDetails toDetails(Item item) {
		
		ItemDetails details = new ItemDetails();
		details.setId(item.getId());
		details.setPrice(item.getPrice());
		details.setDescription(item.getDescription());
		if(item.getBoughtBy()!=null) {
			details.setCustomerId(item.getBoughtBy().getId());
			details.setCustomerName(item.getBoughtBy().getName());
		}
		return details;
	}
}
