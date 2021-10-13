package com.foodbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.foodbox.models.UserDetails;

@Repository
@CrossOrigin
public interface UserDetailsRep extends JpaRepository<UserDetails, String>{

	public UserDetails findByEmailAndPassword(String email, String password);
	
	
	/*
	 * @Modifying
	 * 
	 * @Query("update USER_DETAILS u set u.password = ?1 where u.email = ?2") int
	 * setUserPswrdById(String pswrd, String email);
	 */

}
