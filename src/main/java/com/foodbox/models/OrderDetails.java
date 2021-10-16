package com.foodbox.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails {
	
	public OrderDetails(Long orddtlId, String email, long itemId, int qty, String dlvryAddr, String status) {
		super();
		this.orddtlId = orddtlId;
		this.email = email;
		this.itemId = itemId;
		this.qty = qty;
		this.dlvryAddr = dlvryAddr;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDDTL_ID")
	private Long orddtlId;
	
	private String email;
	private long itemId;
	private int qty;
	private String dlvryAddr;
	private String status;
	private Integer price;
	
	
	

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrderDetails() {
		super();
	}
	public OrderDetails(Long orddtlId, String email, long itemId, int qty, String dlvryAddr) {
		super();
		this.orddtlId = orddtlId;
		this.email = email;
		this.itemId = itemId;
		this.qty = qty;
		this.dlvryAddr = dlvryAddr;
	}
	public Long getOrddtlId() {
		return orddtlId;
	}
	public void setOrddtlId(Long orddtlId) {
		this.orddtlId = orddtlId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getDlvryAddr() {
		return dlvryAddr;
	}
	public void setDlvryAddr(String dlvryAddr) {
		this.dlvryAddr = dlvryAddr;
	}
	
	

}
