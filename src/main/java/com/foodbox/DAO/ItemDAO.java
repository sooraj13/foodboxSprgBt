package com.foodbox.DAO;

import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.foodbox.DTO.ItemResp;
import com.foodbox.models.Items;
import com.foodbox.repositories.ItemRep;

@Component
@Transactional
public class ItemDAO {

	@Autowired
	private ItemRep itemRep;

	public boolean addItem(Items item) {
		System.out.println("1**********");

		try {
			itemRep.save(item);
			return true;
		}
		catch(Exception e) {
			System.out.println("Exce" + e);
			return false;
		}

	}

	public boolean updateItem(Items item) {
		System.out.println("1********1**1:" + item.getId());
		return true;

		/*
		 * try { Optional<Items> itm = itemRep.findById(item.getId());
		 * System.out.println("iddddd:"+itm.get().getId()); if(!itm.isEmpty()) { Items
		 * newItm = itm.get(); if(item.getItemName()!= null &&
		 * !item.getItemName().isEmpty() ) {
		 * System.out.println("name:"+newItm.getItemName());
		 * newItm.setItemName(item.getItemName()); } if(item.getCuisine()!= null &&
		 * !item.getCuisine().isEmpty() ) { newItm.setCuisine(item.getCuisine()); }
		 * if(item.getDescription()!= null && !item.getDescription().isEmpty() ) {
		 * newItm.setDescription(item.getDescription()); } if(item.getPrice()!= null ) {
		 * newItm.setPrice(item.getPrice()); } if(item.getEnable()!= null &&
		 * !item.getEnable().isEmpty()) { newItm.setEnable(item.getEnable()); }
		 * itemRep.save(newItm); return true; } else { itemRep.save(item); } return
		 * false;
		 * 
		 * } catch(Exception e) { System.out.println("Exce" + e); try {
		 * itemRep.save(item); } catch(Exception ex) { System.out.println("Exce2" + ex);
		 * return false; } return true; }
		 */
	}

	public ItemResp getItems() {
		ItemResp resp = new ItemResp();
		resp.setSuccess(false);
		resp.setCode("100");
		try {
			resp.setItemsList(itemRep.findAll());
			resp.setSuccess(true);
			resp.setCode("00");
			return resp;
		}
		catch(Exception e) {
			System.out.println("Exce" + e);
			return resp;
		}
	}



}
