package com.niit.foodcourtbackend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.foodcourtbackend.Cart;
import com.niit.foodcourtbackend.CartItems;
import com.niit.foodcourtbackend.Category;
import com.niit.foodcourtbackend.Product;
import com.niit.foodcourtbackend.dao.CartItemsDao;

@Repository("cartItemsDao")
@Transactional
public class CartItemsDaoImpl implements CartItemsDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCartItems(CartItems cartItems) {

		try {

			sessionFactory.getCurrentSession().persist(cartItems);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deletCartItems(CartItems cartItems) {
		try {
			sessionFactory.getCurrentSession().remove(cartItems);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateCartItems(CartItems cartItems) {
		try {

			sessionFactory.getCurrentSession().update(cartItems);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CartItems getCartItems(Integer id) {
		try {
			return sessionFactory.getCurrentSession().get(CartItems.class, id);

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<CartItems> retreiveAllCartItems() {
		try {

			return (ArrayList<CartItems>) sessionFactory.getCurrentSession()
					.createQuery("from CartItems", CartItems.class).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public CartItems getProduct(int productId, int cartId) {

		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from CartItems where cart_cartId = :cartId and product_productId= :productId",
							CartItems.class)
					.setParameter("cartId", cartId).setParameter("productId", productId).getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
