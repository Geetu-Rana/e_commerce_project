package com.eCart.project.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	
	private LocalDate orderDate;
	
	private LocalDate shipDate;
	
	private LocalDate delevieryDate;
	
	private Double total_order_amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne
	private  Payment payment;
	@OneToOne
	private Shipper shipperId;
	
}
