package com.niit.foodcourtbackend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Category implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	private int catId;
	private String catName;
	private String catDesc;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private Collection<Product> products= new ArrayList<Product>();
	
	
	public Collection<Product> getProducts() {
		return this.products;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	public int getCatId() {
		return this.catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return this.catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatDesc() {
		return this.catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	
	
	
}
