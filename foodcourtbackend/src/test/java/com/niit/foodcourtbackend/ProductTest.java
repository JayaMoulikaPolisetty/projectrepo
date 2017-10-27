package com.niit.foodcourtbackend;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.foodcourtbackend.dao.CategoryDao;
import com.niit.foodcourtbackend.dao.ProductDao;

public class ProductTest {

	AnnotationConfigApplicationContext context;
	ProductDao productDao;
	CategoryDao categoryDao;
	Product product;
	Category category;

@Before
public void init()
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	productDao =(ProductDao)context.getBean("productDao");
	product = new Product();
	categoryDao=(CategoryDao)context.getBean("categoryDao");
	category=new Category();
}


/*@Test
public void test()
{
	category.setCatName("pizza");
	category.setCatDesc("Pizza types veg and non veg");
	product.setProductName("Pizza");
	product.setProductDesc("Burger with extra cheese");
	product.setProductPrice(250);
	product.setCategory(category);
	Assert.assertEquals("Category added successfully", true, categoryDao.addCategory(category) );
	Assert.assertEquals("Product added successfully", true, productDao.addProduct(product) );
	
}*/

/*@Test
public void test()
{
	product.setProductId(1);
	productDao.deleteProduct(product);
}*/

@Test
public void test()
{
	product = productDao.getProduct(2);
	product.setProductDesc("Burger with double extra cheese");
	product.setProductPrice(290);
	category.setCatId(1);
	product.setCategory(category);

	
	Assert.assertEquals("Product updated successfully", true, productDao.updateProduct(product));
}

/*@Test
public void test()
{
	List<Product> products = productDao.retreiveAllProducts();
	for(int i=0;i<products.size();i++)
	{
		Product product = (Product) products.get(i);
		System.out.println(product.getProductName()+","+product.getProductDesc()+","+product.getProductPrice());
	}
	
}*/
}
