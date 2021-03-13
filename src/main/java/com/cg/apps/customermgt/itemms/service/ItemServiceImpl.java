package com.cg.apps.customermgt.itemms.service;

import com.cg.apps.customermgt.itemms.entities.Item;
import com.cg.apps.customermgt.itemms.dao.IItemDao;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	IItemDao dao;
	
	@Transactional
	@Override
	public Item create(double price, String description) {
		Item item=new Item(createId(), price, description, LocalDateTime.now());
		dao.add(item);
		return item;
	}
	
	@Override
	public Item findById(String itemId) {
		Item item=dao.findById(itemId);
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
