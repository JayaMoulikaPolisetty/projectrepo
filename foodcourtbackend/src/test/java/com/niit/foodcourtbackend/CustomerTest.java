package com.niit.foodcourtbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.foodcourtbackend.configuration.HibernateConfiguration;
import com.niit.foodcourtbackend.dao.CartDao;
import com.niit.foodcourtbackend.dao.CustomerDao;

public class CustomerTest {

	   
	AnnotationConfigApplicationContext context;
	CustomerDao customerDao;
	CartDao cartDao;
	Customer customer;
	Cart cart;
	
	
	
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		customerDao=(CustomerDao)context.getBean("customerDao");
		customer=new Customer();
		cartDao=(CartDao)context.getBean("cartDao");
		cart=new Cart();
	
	}
	
	/*@Test
	public void test() {
		
		customer.setFirstName("Manogna");
		customer.setLastName("valiveti");
		customer.setMobile(" 9177569932");
		customer.setUsername("Manu");;
		customer.setPassword("manu123");
		customer.setConfirmPassword("manu123");
		
		cart.setCustomer(customer);
		customer.setCart(cart);
		
		
		Assert.assertEquals("Customer added successfully", true, customerDao.addCustomer(customer));
		Assert.assertEquals("cart added", true, cartDao.addCart(cart));
	}
	*/
	/*@Test
	public void test() {
		
		customer.setCustId(65);
		customerDao.deleteCustomer(customer);
	}*/

	/*@Test
	public void test() {
		
		  customer= customerDao.getCustomer(2);
		  customer.setAddress("Hyderabad");
		  assertEquals("update successful",true,customerDao.updateCustomer(customer));
	}*/
	
	@Test
	public void cartUpdateTest() {
		cart= cartDao.getCart(1);
		cart.setCartQuantity(5);
		assertEquals("update successful",true,cartDao.updateCart(cart));
	}
	
	
/*@Test
	public void test() {
		
		 
		List<Customer> customers = customerDao.retreiveAllCustomers();
		for (int i = 0; i < customers.size(); i++) {
			  Customer customer = (Customer) customers.get(i);
				System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getMobile());
			  }
}
	*/
	/*@Test
	public void test()
	{
		customer= customerDao.getCustomer(3);
		System.out.println(customer.getFirstName());
	
	}*/
	
}

