package com.foodbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.DTO.ItemResp;
import com.foodbox.DTO.Response;
import com.foodbox.models.Items;
import com.foodbox.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/addItem")
	@CrossOrigin
	public Response addItem(@RequestBody Items items) {
		System.out.println("1**********");
		
		Response resp = new Response();
		resp.setSuccess(false);
		resp.setCode("100");
		boolean flag = itemService.addItem(items);
		if(flag) {
			resp.setSuccess(true);
			resp.setCode("00");
		}
		return resp;

	}
	
	@PostMapping("/updateItem")
	@CrossOrigin
	public Response updateItem(@RequestBody Items items) {
		System.out.println("1**********1");
		System.out.println(items);
		
		Response resp = new Response();
		resp.setSuccess(false);
		resp.setCode("100");
		boolean flag = itemService.updateItem(items);
		if(flag) {
			resp.setSuccess(true);
			resp.setCode("00");
		}
		return resp;

	}
	
	@GetMapping("/getItems")
	@CrossOrigin
	public ItemResp getItems() {
	
		ItemResp resp = new ItemResp();
		resp = itemService.getItems();
		if(resp != null ) {
			resp.setSuccess(true);
			resp.setCode("00");
		}
		else {
			resp.setSuccess(false);
			resp.setCode("100");
		}
		return resp;

	}
	



}
