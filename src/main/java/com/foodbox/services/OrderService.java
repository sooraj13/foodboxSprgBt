package com.foodbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.DAO.OrderDAO;
import com.foodbox.DTO.CartResp;
import com.foodbox.DTO.JsonResponse;
import com.foodbox.models.OrderDetails;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	public JsonResponse addToCart(OrderDetails orderDetails) {

		return orderDAO.addToCart(orderDetails);
	}

	public List<CartResp> getCartDtls(OrderDetails orderDetails) {
		return orderDAO.getCartDtls(orderDetails);
	}

	public JsonResponse placeOrder(JsonResponse resp) {
		return orderDAO.placeOrder(resp);
	}

}
