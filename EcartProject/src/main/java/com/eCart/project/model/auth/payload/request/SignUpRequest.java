package com.eCart.project.model.auth.payload.request;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
@Data
public class SignUpRequest {
	
	@NotNull
	@NotBlank
	private String firstName;
	
	@NotNull
	@NotBlank
	private String lastName;

	@NotNull
	@NotBlank
	@Pattern(regexp = "")
	private String phonNumber;
	
	@Email(message = "email should in example@email.com")
	private String email;
	
	@Range(min = 16, max = 80, message = "age should be in the range of 16 to 80 " )
	private Integer age;
	
	@Pattern(regexp = "")
	@NotNull(message = "password can not be null ")
	@NotBlank(message = "password can not be blank ")
	private String password;
	
	@NotNull(message = "gender can not be Null")
	@NotBlank(message = "gender can not be Blank")
	private String gender;
	
	private Set<String> roles;
	
	@PastOrPresent(message = "creation date can not be in Future ")
	private LocalDate created_Date;
	
	public SignUpRequest(){
		
	}

	public SignUpRequest(@NotNull @NotBlank String firstName, @NotNull @NotBlank String lastName,
			@NotNull @NotBlank @Pattern(regexp = "") String phonNumber,
			@Email(message = "email should in example@email.com") String email,
			@Range(min = 16, max = 80, message = "age should be in the range of 16 to 80 ") Integer age,
			@Pattern(regexp = "") @NotNull(message = "password can not be null ") @NotBlank(message = "password can not be blank ") String password,
			@NotNull(message = "gender can not be Null") @NotBlank(message = "gender can not be Blank") String gender,
			Set<String> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phonNumber = phonNumber;
		this.email = email;
		this.age = age;
		this.password = password;
		this.gender = gender;
		this.roles = roles;
		this.created_Date = LocalDate.now();
	}

	public LocalDate getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(LocalDate localDate) {
		this.created_Date = LocalDate.now();
	}
	
	
	
}

