package com.niit.foodcourtbackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.foodcourtbackend.Customer;
import com.niit.foodcourtbackend.dao.CustomerDao;

@Repository("customerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCustomer(Customer customer) {
		
		try {
			
			sessionFactory.getCurrentSession().save(customer);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().remove(customer);
			
			return true;
			
		}
		catch(Exception e) 
		{
		return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			
		    sessionFactory.getCurrentSession().update(customer);
			return true;
			
		}
	catch(Exception e) {
		return false;
	}
		
	}
	
	
	public Customer getCustomer(Integer id)
	{
		try {
		return sessionFactory.getCurrentSession().get(Customer.class,id);
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	
	public List<Customer> retreiveAllCustomers() 
	{
					
			try {
								
				return sessionFactory.getCurrentSession().createQuery("from Customer", Customer.class).getResultList();
		}
			catch (HibernateException e) {
				e.printStackTrace();
				return null;
				
			}
			
	}

	
	
	

}

