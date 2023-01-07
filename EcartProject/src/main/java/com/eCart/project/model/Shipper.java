package com.eCart.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ShipperId;
	
	private String companyName;
	
	private String phoneNumber;
}
