package com.eCart.project.model.auth.payload.response;

import lombok.Data;

@Data
public class SignUpResponse {
	
	private String message;

	public SignUpResponse(String message) {
		super();
		this.message = message;
	}

	public SignUpResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
