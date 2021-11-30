package com.foodbox.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.foodbox.DTO.UserDetailsDTO;
import com.foodbox.models.UserDetail;
import com.foodbox.repositories.UserDetailsRep;
//import com.mysql.cj.xdevapi.DatabaseObject.DbObjectStatus;

@Component
@Transactional
public class UserDetailsDAO {

	@Autowired
	private UserDetailsRep userDetailsRep;

	@Autowired
	private PasswordEncoder bcryptEncoder;


	public boolean addUserDetails(UserDetailsDTO userDetails) {
		try {
			UserDetail usr =new UserDetail();
			usr.setEmail(userDetails.getEmail());
			usr.setPassword(userDetails.getPassword());
			usr.setPhoneNr(userDetails.getPhoneNr());
			usr.setUserName(userDetails.getUserName());
			userDetailsRep.save(usr);
			return true;
		}
		catch(Exception e) {
			System.out.println("exception : " + e);
			return false;

		}
	}

	public Boolean validateUser(UserDetailsDTO userDetails) {
		try {
			UserDetail usr = userDetailsRep.findByEmail(userDetails.getEmail());
			if(bcryptEncoder.matches(userDetails.getPassword(), usr.getPassword()))
				return true;
			return false;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Boolean updatePassword(UserDetailsDTO userDetails) {
		try {
			UserDetail usr = userDetailsRep.getById(userDetails.getEmail());
			//if(!bcryptEncoder.matches(userDetails.getPassword(), usr.getPassword()))
				//return false;
			userDetails.setPassword(bcryptEncoder.encode(userDetails.getPassword()));
			if(usr != null) {
				usr.setPassword(userDetails.getPassword());
				userDetailsRep.save(usr);
				return true;
			}
		}
		catch(Exception e) {
			return false;
		}
		return false;
	}

}
