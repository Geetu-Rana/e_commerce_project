package com.eCart.project.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
	
	private String buildingName;
	
	private String StreetNo;
	
	private String area;
	
	private String city;
	
	private String state;
	
	private String country;
	
	@Size(min = 6,max = 6)
	private String pincode;
	@NotNull
	private String type;
	
	@NotNull
	private String phoneNumber;
	
}
