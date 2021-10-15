package com.foodbox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.DAO.ItemDAO;
import com.foodbox.DTO.ItemResp;
import com.foodbox.models.Items;

@Service
public class ItemService {

	@Autowired
	private ItemDAO itemDAO;
	
	public boolean addItem(Items item) {
		System.out.println("1**********1");
		
		return itemDAO.addItem(item);
	}

	public boolean updateItem(Items item) {
		
		return itemDAO.updateItem(item);
	}

	public ItemResp getItems() {
		ItemResp resp = new ItemResp();
		resp = itemDAO.getItems();
		return resp;
	}


}
