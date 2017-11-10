package com.niit.foodcourtbackend.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.foodcourtbackend.Cart;
import com.niit.foodcourtbackend.Category;
import com.niit.foodcourtbackend.dao.CartDao;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCart(Cart cart) {
		
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCart(Cart cart) {
		
		try {
			sessionFactory.getCurrentSession().remove(cart);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		
		try {

			sessionFactory.getCurrentSession().update(cart);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Cart getCart(Integer id) {
		
		try {
			return sessionFactory.getCurrentSession().get(Cart.class, id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
