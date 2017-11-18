package com.niit.foodcourtbackend;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@OneToMany(mappedBy="orderTable",fetch=FetchType.EAGER)
	List<OrderedItems> orderedItems;
	
	@OneToOne
	private Customer customer;

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderedItems> getOrderedItems() {
		return this.orderedItems;
	}

	public void setOrderedItems(List<OrderedItems> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


}
