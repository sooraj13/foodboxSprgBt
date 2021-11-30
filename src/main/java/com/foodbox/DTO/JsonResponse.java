package com.foodbox.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class JsonResponse {
	
	
	@ApiModelProperty(notes = "Success flag ",name="success",required=true)
	private boolean success;
	
	private String code ;
	
	private String email;
	
	public JsonResponse() {
		super();

	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public JsonResponse(boolean success, String code) {
		super();
		this.success = success;
		this.code = code;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
