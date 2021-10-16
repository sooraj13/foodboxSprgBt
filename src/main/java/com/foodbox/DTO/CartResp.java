package com.foodbox.DTO;

public class CartResp {



	private long itemId;
	private int qty;
	private Integer price;
	private String itemName;
	private String cuisine;
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public CartResp(long itemId, int qty, Integer price, String itemName, String cuisine) {
		super();
		this.itemId = itemId;
		this.qty = qty;
		this.price = price;
		this.itemName = itemName;
		this.cuisine = cuisine;
	}
	public CartResp() {
		super();
	}
	

}
