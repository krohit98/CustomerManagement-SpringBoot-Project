package com.cg.apps.customermgt.customerms.util;

import com.cg.apps.customermgt.customerms.entities.*;
import com.cg.apps.customermgt.itemms.entities.Item;
import com.cg.apps.customermgt.customerms.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {
	
	public CustomerDetails customerDetailsById(Customer customer) {
		CustomerDetails details = new CustomerDetails();
		details.setId(customer.getId());
		details.setName(customer.getName());
		details.setAccountId(customer.getAccount().getId());
		details.setBalance(customer.getAccount().getBalance());
		return details;
	}
	
	public List<GetItemsBoughtRequest> getItemList(Set<Item> itemSet){
		List<GetItemsBoughtRequest> itemList = new ArrayList<>();
		for(Item item : itemSet) {
			GetItemsBoughtRequest itemsBought = new GetItemsBoughtRequest();
			itemsBought.setId(item.getId());
			itemsBought.setPrice(item.getPrice());
			itemList.add(itemsBought);
		}
		return itemList;
	}
}
