package com.eCart.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.Range;
import lombok.Data;

@Entity
@Data
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderDetailId;
	
	@Range(min = 1, max = 5, message = "User can buy minimum 1 or maximum 5 Item once")
	private Integer quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Order order;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Item item;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shipper shipper;
}
