package com.niit.foodcourtfrontend;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.foodcourtbackend.Cart;
import com.niit.foodcourtbackend.CartItems;
import com.niit.foodcourtbackend.Customer;
import com.niit.foodcourtbackend.Product;
import com.niit.foodcourtbackend.dao.CartDao;
import com.niit.foodcourtbackend.dao.CartItemsDao;
import com.niit.foodcourtbackend.dao.CustomerDao;
import com.niit.foodcourtbackend.dao.ProductDao;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CartItemsDao cartItemsDao;
	
	@Autowired
	CartDao cartDao;

	@RequestMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable("productId") int productId, Model m, @RequestParam(value ="quantity") int quantity, Principal principal)
	{
		Product product = productDao.getProduct(productId);
		
		Customer customer = customerDao.getCustomerDetails(principal.getName());
		Cart cart = customer.getCart();
		CartItems cartItems = new CartItems();
		cartItems.setProduct(product);
		cartItems.setCartItemQuantity(quantity);
		cartItems.setCart(cart);
		cartItems.setCartItemPrice(cartItems.getCartItemQuantity() * product.getProductPrice());
		ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
		itemsList.add(cartItems);
		cart.setCartQuantity(cart.getCartQuantity()+cartItems.getCartItemQuantity());
		cart.setTotalCartPrice(cart.getTotalCartPrice()+cartItems.getCartItemPrice());
		cart.setCartItems(itemsList);
		
		cartItemsDao.addCartItems(cartItems);
		cartDao.updateCart(cart);
		
		return "redirect:/products";
	}
}
