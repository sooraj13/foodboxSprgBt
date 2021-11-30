package com.foodbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.DTO.JsonResponse;
import com.foodbox.DTO.UserDetailsDTO;
import com.foodbox.services.UserDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "User login Page controller", description = "User login Page APIs")
@RestController
@RequestMapping("/user")
public class UserDetailsController {
	@Autowired
	private UserDetailsService userDetailsService;

	@ApiOperation(value="Register User" , response=JsonResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"),
			@ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not Found!") })
	
	@PostMapping("/register")
	@CrossOrigin
	public JsonResponse addUserDetails(@RequestBody UserDetailsDTO userDetails) {
		
		JsonResponse resp = new JsonResponse();
		resp.setCode("100");
		resp.setSuccess(false);
		Boolean flag = userDetailsService.addUserDetails(userDetails);
		if(flag) {
			resp.setSuccess(true);
			resp.setCode("00");
		}
		return resp;
	}
	

	
	
	@PostMapping("/validate")
	@CrossOrigin
	public JsonResponse validateUser(@RequestBody UserDetailsDTO userDetails) {
		
		
		JsonResponse resp = new JsonResponse();
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
	public JsonResponse updatePassword(@RequestBody UserDetailsDTO userDetails,@RequestHeader("Authorization") String token) {
		
		JsonResponse resp = new JsonResponse();
		resp.setCode("100");
		resp.setSuccess(false);
		Boolean flag = userDetailsService.updatePassword(userDetails,token);
		if(flag) {
			resp.setSuccess(true);
			resp.setCode("00");
		}
		return resp;
		
	}

}
