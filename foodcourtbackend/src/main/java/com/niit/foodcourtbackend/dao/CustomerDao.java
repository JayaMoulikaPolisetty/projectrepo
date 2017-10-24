package com.niit.foodcourtbackend.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.foodcourtbackend.Customer;

@Component
public interface CustomerDao {

	boolean addCustomer(Customer customer);
	boolean deleteCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	Customer getCustomer(Integer id);
	List<Customer> retreiveAllCustomers();
	
	}


