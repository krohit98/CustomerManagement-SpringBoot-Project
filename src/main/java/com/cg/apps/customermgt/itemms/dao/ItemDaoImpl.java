package com.cg.apps.customermgt.itemms.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cg.apps.customermgt.itemms.entities.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Item add(Item item) {
		
		entityManager.persist(item);
		return item;
	}
	
	@Override 
	public Item update(Item item) {
		
		item = entityManager.merge(item);
		return item;
	}
	
	@Override
	public Item findById(String itemId) {
		
		Item item = entityManager.find(Item.class, itemId);
		return item;
	}
}
