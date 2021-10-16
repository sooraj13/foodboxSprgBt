package com.foodbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.foodbox.models.Items;

@Repository
@CrossOrigin
public interface ItemRep extends JpaRepository<Items, Long>{

	
	

}
