package com.foodbox.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.foodbox.models.OrderDetails;
@Repository
@CrossOrigin
public interface OrderRep extends JpaRepository<OrderDetails, Long>{
	
	//@Query("select o from OrderDetails where o.itemId = ?1 and o.email = ?2 and o.status = ?3")
	List<OrderDetails> findByItemIdAndEmailAndStatus(Long itemId , String email , String status);

	List<OrderDetails> findByEmailAndStatus(String email, String string);
	
}
