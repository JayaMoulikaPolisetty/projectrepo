package com.niit.foodcourtbackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.foodcourtbackend.Category;
import com.niit.foodcourtbackend.OrderedItems;
import com.niit.foodcourtbackend.dao.OrderedItemsDao;

public class OrderedItemsDaoImpl implements OrderedItemsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addOrderedItem(OrderedItems orderedItems) {
		try {
			sessionFactory.getCurrentSession().save(orderedItems);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean deleteOrderedItem(OrderedItems orderedItems) {
		try {
			sessionFactory.getCurrentSession().delete(orderedItems);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateOrderedITem(OrderedItems orderedItems) {
		try {
			sessionFactory.getCurrentSession().update(orderedItems);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public OrderedItems getOrderedItem(int id) {
		try
		{
			return sessionFactory.getCurrentSession().get(OrderedItems.class, id);
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
			
		}
	}

	@Override
	public List<OrderedItems> orderedItems() {
		try {

			return sessionFactory.getCurrentSession().createQuery("from OrderedItems", OrderedItems.class).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
