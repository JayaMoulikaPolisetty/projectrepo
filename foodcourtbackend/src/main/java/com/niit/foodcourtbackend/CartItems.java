package com.niit.foodcourtbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	
	private double cartItemPrice;
	
	private int cartItemQuantity;
	
	@ManyToOne
	private Cart cart;
	
	@OneToOne
	private Product product;

}
