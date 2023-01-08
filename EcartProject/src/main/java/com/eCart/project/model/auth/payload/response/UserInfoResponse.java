package com.eCart.project.model.auth.payload.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserInfoResponse {
	
	private Long Id;
	
	private String userName;
	
	private String email;
	
	private String phoneNumber;
	
	private Integer age;
	
	private String gender;
	
	private List<String> roles;
	
	
	
}
