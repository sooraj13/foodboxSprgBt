package com.foodbox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.DTO.CartResp;
import com.foodbox.DTO.JsonResponse;
import com.foodbox.models.OrderDetails;
import com.foodbox.services.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addToCart")
	public JsonResponse addToCart(@RequestBody OrderDetails orderDetails) {
		return orderService.addToCart(orderDetails);
		
	}
	
	@PostMapping("/getCartDtls")
	public List<CartResp> getCartDtls(@RequestBody OrderDetails orderDetails) {
		return orderService.getCartDtls(orderDetails);
		
	}
	
	@PostMapping("/placeOrder")
	public JsonResponse placeOrder(@RequestBody JsonResponse resp) {
		return orderService.placeOrder(resp);
		
	}
	
	
	

}
