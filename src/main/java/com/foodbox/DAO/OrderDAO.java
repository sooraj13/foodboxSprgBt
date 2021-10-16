package com.foodbox.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.foodbox.DTO.CartResp;
import com.foodbox.DTO.Response;
import com.foodbox.models.Items;
import com.foodbox.models.OrderDetails;
import com.foodbox.repositories.ItemRep;
import com.foodbox.repositories.OrderRep;

@Component
@Transactional
public class OrderDAO {


	@Autowired
	private OrderRep orderRep ;
	
	@Autowired
	private ItemRep itemRep;

	public Response addToCart(OrderDetails orderDetails) {

		System.out.println("11/111");
		Response resp = new Response();
		resp.setSuccess(false);
		resp.setCode("100");
		try {
			orderDetails.setQty(1);
			Items item = itemRep.getById(orderDetails.getItemId());
			orderDetails.setPrice(item.getPrice());
			List<OrderDetails> ordDetlExisting = orderRep.findByItemIdAndEmailAndStatus(orderDetails.getItemId(),orderDetails.getEmail(),orderDetails.getStatus());
			if(ordDetlExisting != null && !ordDetlExisting.isEmpty()) {
				OrderDetails ordDtl = ordDetlExisting.get(0);
				ordDtl.setQty(ordDtl.getQty() + 1);
				ordDtl.setPrice(orderDetails.getPrice() * ordDtl.getQty());
				orderRep.save(ordDtl);
			}
			else{
				orderRep.save(orderDetails);
			}
			resp.setSuccess(true);
			resp.setCode("00");
		}
		catch(Exception e) {
			System.out.println("excep1:" + e);
		}
		return resp;
	}

	public List<CartResp> getCartDtls(OrderDetails orderDetails) {
		List<CartResp> cartList = new ArrayList<>();
		try {
			List<OrderDetails> ordList = orderRep.findByEmailAndStatus(orderDetails.getEmail(),"In Cart");
			for(OrderDetails ord : ordList) {
				CartResp resp = new CartResp();
				Items item = itemRep.getById(ord.getItemId());
				resp.setCuisine(item.getCuisine());
				resp.setItemName(item.getItemName());
				resp.setQty(ord.getQty());
				resp.setPrice(item.getPrice());
				cartList.add(resp);
			}
		}
		catch(Exception e) {
			return null;
		}
		return cartList;
	}

}
