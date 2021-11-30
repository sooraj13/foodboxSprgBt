package com.foodbox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.foodbox.DAO.UserDetailsDAO;
import com.foodbox.DTO.UserDetailsDTO;
import com.foodbox.components.JwtTokenUtil;
import com.foodbox.models.UserDetail;
import com.foodbox.repositories.UserDetailsRep;

@Service
public class UserDetailsService {


	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private PasswordEncoder bcryptEncoder;


	public Boolean addUserDetails(UserDetailsDTO userDetails) {
		try {
			userDetails.setPassword(bcryptEncoder.encode(userDetails.getPassword()));
			return userDetailsDAO.addUserDetails(userDetails);
		}
		catch(Exception e) {
			return false;
		}
	}

	public Boolean validateUser(UserDetailsDTO userDetails) {
		return userDetailsDAO.validateUser(userDetails);

	}

	public Boolean updatePassword(UserDetailsDTO userDetails,String token) {

		try {
			String jwtToken = token.substring(7);
			String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			if(username.equals(userDetails.getEmail()))
				return userDetailsDAO.updatePassword(userDetails);
			return false;
		}
		catch(Exception e) {
			return false;
		}

	}




}
