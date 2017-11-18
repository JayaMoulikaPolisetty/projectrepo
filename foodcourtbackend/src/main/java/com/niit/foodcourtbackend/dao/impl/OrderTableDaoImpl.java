package com.niit.foodcourtbackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.foodcourtbackend.Category;
import com.niit.foodcourtbackend.OrderTable;
import com.niit.foodcourtbackend.dao.OrderTableDao;

public class OrderTableDaoImpl implements OrderTableDao{
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public boolean placeOrder(OrderTable orderTable) {
		
			try {
			
			sessionFactory.getCurrentSession().save(orderTable);
			return true;
			
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean cancelOrder(OrderTable orderTable) {
		try
		{
			sessionFactory.getCurrentSession().remove(orderTable);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public OrderTable getOrder(Integer id) {
		
		try {
			return sessionFactory.getCurrentSession().get(OrderTable.class, id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	
}
