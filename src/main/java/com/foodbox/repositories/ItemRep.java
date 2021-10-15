package com.foodbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.models.Items;

@Repository
public interface ItemRep extends JpaRepository<Items, Long>{
	
	

}
