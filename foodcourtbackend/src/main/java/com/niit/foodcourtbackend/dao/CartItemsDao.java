package com.niit.foodcourtbackend.dao;

import java.util.ArrayList;
import java.util.List;

import com.niit.foodcourtbackend.CartItems;
import com.niit.foodcourtbackend.Product;

public interface CartItemsDao {

	boolean addCartItems(CartItems cartItems);

	boolean deletCartItems(CartItems cartItems);

	boolean updateCartItems(CartItems cartItems);

	CartItems getCartItems(Integer id);
	
	ArrayList<CartItems> retreiveAllCartItems();
}
