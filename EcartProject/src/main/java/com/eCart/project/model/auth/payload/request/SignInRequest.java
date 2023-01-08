package com.eCart.project.model.auth.payload.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SignInRequest {
	@NotNull(message = "userName can not be null")
	private String userName;
	
	@NotNull(message = "password can not be null")
	@Pattern(regexp = "", message = "password should contain one special charecter and number with upper case lower case letter")
	private String password;
}
