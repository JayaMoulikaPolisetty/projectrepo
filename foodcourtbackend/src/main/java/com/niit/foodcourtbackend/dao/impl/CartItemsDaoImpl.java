package com.niit.foodcourtbackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.foodcourtbackend.CartItems;
import com.niit.foodcourtbackend.dao.CartItemsDao;

@Repository("cartItemsDao")
@Transactional
public class CartItemsDaoImpl implements CartItemsDao{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addCartItems(CartItems cartItems) {
		
		return false;
	}

	@Override
	public boolean deletCartItems(CartItems cartItems) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCartItems(CartItems cartItems) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CartItems getCartItems(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
