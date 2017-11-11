   package com.niit.foodcourtbackend;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.foodcourtbackend.dao.CartDao;
import com.niit.foodcourtbackend.dao.CartItemsDao;
import com.niit.foodcourtbackend.dao.ProductDao;

public class CartItemsTest {
	
	private AnnotationConfigApplicationContext context;
	private CartItemsDao cartItemsDao;
	private CartDao cartDao;
	private ProductDao productDao;
	private Cart cart;
	private CartItems cartItems;
	private Product product;
	
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDao=(CartDao)context.getBean("cartDao");
		productDao=(ProductDao)context.getBean("productDao");
		cartItemsDao=(CartItemsDao)context.getBean("cartItemsDao");
	}
	
	@Test
	public void addCartItemsTest()
	{
		//getting Product
		product=productDao.getProduct(1);
		//creating cartItem
		cartItems=new CartItems();
		//setting product
		cartItems.setProduct(product);
		//setting quantity
		cartItems.setCartItemQuantity(3);
		//setting price 
		cartItems.setCartItemPrice(product.getProductPrice()*cartItems.getCartItemQuantity());
		// cart object
		cart=cartDao.getCart(2);
		//setting cart
		cartItems.setCart(cart);
		
		//list of cartItems
		ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
		itemsList.add(cartItems);
		cart.setCartQuantity(cart.getCartQuantity()+cartItems.getCartItemQuantity());
		cart.setTotalCartPrice(cart.getTotalCartPrice()+cartItems.getCartItemPrice());
		cart.setCartItems(itemsList);
		
		Assert.assertEquals("addng of cartItems",true,cartItemsDao.addCartItems(cartItems));
		Assert.assertEquals("updating of cart",true,cartDao.updateCart(cart));
		
	}
	

}
