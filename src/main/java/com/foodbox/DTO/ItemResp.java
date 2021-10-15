package com.foodbox.DTO;

import java.util.ArrayList;
import java.util.List;

import com.foodbox.models.Items;

public class ItemResp extends Response{
	
	private List<Items> itemsList ;

	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	public ItemResp(List<Items> itemsList) {
		super();
		this.itemsList = itemsList;
	}

	public ItemResp() {
		super();
	}


	
	
	

}
