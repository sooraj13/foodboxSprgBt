package com.foodbox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.DAO.UserDetailsDAO;
import com.foodbox.models.UserDetails;
import com.foodbox.repositories.UserDetailsRep;

@Service
public class UserDetailsService {
	
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	public Boolean addUserDetails(UserDetails userDetails) {
		return userDetailsDAO.addUserDetails(userDetails);
	}

	public Boolean validateUser(UserDetails userDetails) {
		return userDetailsDAO.validateUser(userDetails);
		
	}

	public Boolean updatePassword(UserDetails userDetails) {
		return userDetailsDAO.updatePassword(userDetails);
	}
	
	
	

}
