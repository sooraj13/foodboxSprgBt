package com.foodbox.DTO;

public class Response {
	
	
	
	private boolean success;
	private String code ;
	
	public Response() {
		super();

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
