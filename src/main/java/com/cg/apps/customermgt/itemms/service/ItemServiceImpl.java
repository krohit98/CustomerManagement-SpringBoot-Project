package com.cg.apps.customermgt.itemms.service;

import com.cg.apps.customermgt.itemms.entities.Item;
import com.cg.apps.customermgt.itemms.exceptions.ItemNotFoundException;
import com.cg.apps.customermgt.customerms.entities.Customer;
import com.cg.apps.customermgt.customerms.service.CustomerServiceImpl;
import com.cg.apps.customermgt.itemms.dao.IItemRepository;
import com.cg.apps.customermgt.customerms.dao.ICustomerRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ItemServiceImpl implements IItemService {

	//@Autowired
	//IItemDao itemDao;
	
	//@Autowired
	//ICustomerDAO customerDao;
	
	@Autowired
	IItemRepository itemRepository;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	CustomerServiceImpl service;
	
	@Transactional
	@Override
	public Item create(double price, String description) {
		Item item=new Item(createId(), price, description, LocalDateTime.now());
		//itemDao.add(item);
		itemRepository.save(item);
		return item;
	}
	
	@Override
	public Item findById(String itemId) {
		//Item item=itemDao.findById(itemId);
		Item item;
		Optional<Item> optional = itemRepository.findById(itemId);
		if(!optional.isPresent()) {
			throw new ItemNotFoundException("Item doesn't exist");
		}
		else {
			item = optional.get();
		}
		return item;
	}
	
	@Transactional
	@Override
	public Item buyItem(String itemId, Long customerId) {
		//Customer customer = customerDao.findByID(customerId);
		Customer customer = service.findByID(customerId);
		//Item item = itemDao.findById(itemId);
		Item item = findById(itemId);
		item.setBoughtBy(customer);
		//itemDao.update(item);
		itemRepository.save(item);
		Set<Item> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		//customerDao.update(customer);
		customerRepository.save(customer);
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
