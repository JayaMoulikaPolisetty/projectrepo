package com.niit.foodcourtbackend.dao;

import com.niit.foodcourtbackend.Cart;

public interface CartDao {

	public boolean addCart(Cart cart);

	public boolean deleteCart(Cart cart);

	public boolean updateCart(Cart cart);

	public Cart getCart(Integer cartId);

}
