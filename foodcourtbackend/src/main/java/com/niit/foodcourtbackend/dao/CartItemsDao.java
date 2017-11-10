package com.niit.foodcourtbackend.dao;

import com.niit.foodcourtbackend.CartItems;

public interface CartItemsDao {

	boolean addCartItems(CartItems cartItems);

	boolean deletCartItems(CartItems cartItems);

	boolean updateCartItems(CartItems cartItems);

	CartItems getCartItems(Integer id);
}
