package com.niit.foodcourtbackend;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderedItems 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderedItemId;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Product product;
	
	private double unitPrice;
	
	private double orderedItemPrice;
	
	private int orderedItemQuantity;

	@ManyToOne
	private OrderTable orderTable;
	
	public int getOrderedItemId() {
		return this.orderedItemId;
	}

	public void setOrderedItemId(int orderedItemId) {
		this.orderedItemId = orderedItemId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getOrderedItemPrice() {
		return this.orderedItemPrice;
	}

	public void setOrderedItemPrice(double orderedItemPrice) {
		this.orderedItemPrice = orderedItemPrice;
	}

	public int getOrderedItemQuantity() {
		return this.orderedItemQuantity;
	}

	public void setOrderedItemQuantity(int orderedItemQuantity) {
		this.orderedItemQuantity = orderedItemQuantity;
	}

	public OrderTable getOrderTable() {
		return this.orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	
	
}
