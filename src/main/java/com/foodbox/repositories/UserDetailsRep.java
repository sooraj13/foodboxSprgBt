package com.foodbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.foodbox.models.UserDetail;

@Repository
@CrossOrigin
public interface UserDetailsRep extends JpaRepository<UserDetail, String>{

	public UserDetail findByEmailAndPassword(String email, String password);
	
	public UserDetail findByEmail(String email);
	
	
	/*
	 * @Modifying
	 * 
	 * @Query("update USER_DETAILS u set u.password = ?1 where u.email = ?2") int
	 * setUserPswrdById(String pswrd, String email);
	 */

}
