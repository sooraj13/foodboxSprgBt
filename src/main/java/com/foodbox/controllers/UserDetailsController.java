package com.foodbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.DTO.Response;
import com.foodbox.models.UserDetails;
import com.foodbox.services.UserDetailsService;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	@Autowired
	private UserDetailsService userDetailsService;

	
	@PostMapping("/register")
	@CrossOrigin
	public Response addUserDetails(@RequestBody UserDetails userDetails) {
		
		Response resp = new Response();
		resp.setCode("100");
		resp.setSuccess(false);
		Boolean flag = userDetailsService.addUserDetails(userDetails);
		if(flag) {
			resp.setSuccess(true);
			resp.setCode("00");
		}
		return resp;
	}
	
	@GetMapping("/validate")
	@CrossOrigin
	public Response validateUser() {
		Response resp = new Response();
		resp.setCode("00");
		resp.setSuccess(true);
		return resp;
		
	}
	
	@PostMapping("/validate")
	@CrossOrigin
	public Response validateUser(@RequestBody UserDetails userDetails) {
		Response resp = new Response();
		resp.setCode("100");
		resp.setSuccess(false);
		resp.setEmail(userDetails.getEmail());
		Boolean flag = userDetailsService.validateUser(userDetails);
		if(flag) {
			resp.setSuccess(true);
			resp.setCode("00");
		}
		return resp;
		
	}
	
	@PostMapping("/frgtPswrd")
	@CrossOrigin
	public Response updatePassword(@RequestBody UserDetails userDetails) {
		Response resp = new Response();
		resp.setCode("100");
		resp.setSuccess(false);
		Boolean flag = userDetailsService.updatePassword(userDetails);
		if(flag) {
			resp.setSuccess(true);
			resp.setCode("00");
		}
		return resp;
		
	}

}
