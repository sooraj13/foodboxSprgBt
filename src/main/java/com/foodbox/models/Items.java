package com.foodbox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	private String itemName;
	
	private String cuisine;
	
	private String description;
	
	private Integer price;
	
	private String enable ;
	
	




	public Items() {
		super();
	}



	public Items(Long id, String itemName, String cuisine, String description, Integer price, String enable) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.cuisine = cuisine;
		this.description = description;
		this.price = price;
		this.enable = enable;
	}






	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	
	

}
