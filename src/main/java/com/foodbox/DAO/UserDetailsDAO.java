package com.foodbox.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.foodbox.models.UserDetails;
import com.foodbox.repositories.UserDetailsRep;
//import com.mysql.cj.xdevapi.DatabaseObject.DbObjectStatus;

@Component
@Transactional
public class UserDetailsDAO {
	
	@Autowired
	private UserDetailsRep userDetailsRep;

	public boolean addUserDetails(UserDetails userDetails) {
		try {
		userDetailsRep.save(userDetails);
		return true;
		}
		catch(Exception e) {
			System.out.println("exception : " + e);
			return false;
			
		}
	}

	public Boolean validateUser(UserDetails userDetails) {
		UserDetails email = userDetailsRep.findByEmailAndPassword(userDetails.getEmail(),userDetails.getPassword());
		if(email!=null) {
			return true;
		}
		return false;
	}

	public Boolean updatePassword(UserDetails userDetails) {
		try {
		UserDetails dbObj = userDetailsRep.getById(userDetails.getEmail());
		if(dbObj != null) {
			dbObj.setPassword(userDetails.getPassword());
			userDetailsRep.save(dbObj);
			return true;
		}
		}
		catch(Exception e) {
			return false;
		}
		
		return false;
	}

}
