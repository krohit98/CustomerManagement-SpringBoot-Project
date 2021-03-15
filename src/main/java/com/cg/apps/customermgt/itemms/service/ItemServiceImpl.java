package com.cg.apps.customermgt.itemms.service;

import com.cg.apps.customermgt.itemms.entities.Item;
import com.cg.apps.customermgt.customerms.entities.Customer;
import com.cg.apps.customermgt.itemms.dao.IItemDao;
import com.cg.apps.customermgt.customerms.dao.ICustomerDAO;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	IItemDao itemDao;
	
	@Autowired
	ICustomerDAO customerDao;
	
	@Transactional
	@Override
	public Item create(double price, String description) {
		Item item=new Item(createId(), price, description, LocalDateTime.now());
		itemDao.add(item);
		return item;
	}
	
	@Override
	public Item findById(String itemId) {
		Item item=itemDao.findById(itemId);
		return item;
	}
	
	@Transactional
	@Override
	public Item buyItem(String itemId, Long customerId) {
		Customer customer = customerDao.findByID(customerId);
		Item item = itemDao.findById(itemId);
		item.setBoughtBy(customer);
		itemDao.update(item);
		Set<Item> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		customerDao.update(customer);
		return item;
	}
	
	public String createId() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 10;
		for(int i=0;i<length;i++) {
			int index=random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String id=sb.toString();
		return id;
	}
	
}
