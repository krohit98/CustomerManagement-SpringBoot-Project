package com.cg.apps.customermgt.itemms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.customermgt.itemms.entities.Item;

public interface IItemRepository extends JpaRepository<Item, String> {

}
