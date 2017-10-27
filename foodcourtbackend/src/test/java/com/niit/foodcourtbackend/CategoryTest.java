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
import com.niit.foodcourtbackend.dao.CategoryDao;

public class CategoryTest {

	AnnotationConfigApplicationContext context;
	Category category;
	CategoryDao categoryDao;
	
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDao=(CategoryDao)context.getBean("categoryDao");
		category=new Category();
	
	}
	
	@Test
	public void test() {
		
		category.setCatName("Burgers");
		category.setCatDesc("Veg and chicken Burgers");
		
		
		Assert.assertEquals("Category added successfully", true, categoryDao.addCategory(category) );
	}
}
