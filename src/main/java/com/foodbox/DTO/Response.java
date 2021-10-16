package com.foodbox.DTO;

public class Response {
	
	
	
	private boolean success;
	private String code ;
	private String email;
	
	public Response() {
		super();

	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Response(boolean success, String code) {
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
