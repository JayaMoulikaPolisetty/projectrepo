package com.niit.foodcourtfrontend;

import java.util.List;
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
		CartItems cartItems=cartItemsDao.getProduct(productId, cart.getCartId());
		if(cartItems==null)
		{
		cartItems = new CartItems();
		cartItems.setProduct(product);
		cartItems.setCartItemQuantity(quantity);
		cartItems.setCart(cart);
		cartItems.setCartItemPrice(cartItems.getCartItemQuantity() * product.getProductPrice());
		ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
		itemsList.add(cartItems);
		cart.setCartQuantity(cart.getCartQuantity()+cartItems.getCartItemQuantity());
		cart.setTotalCartPrice(cart.getTotalCartPrice()+cartItems.getCartItemPrice());
		cart.setCartItems(itemsList);
		m.addAttribute("cartItems",itemsList);
		cartItemsDao.addCartItems(cartItems);
		
		}
		else{
			cartItems.setProduct(product);
			cartItems.setCartItemPrice(cartItems.getCartItemPrice()+(quantity*product.getProductPrice()));
			cartItems.setCartItemQuantity(cartItems.getCartItemQuantity()+quantity);
			
			ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
			itemsList.add(cartItems);
			cart.setCartQuantity(cart.getCartQuantity()+cartItems.getCartItemQuantity());
			cart.setTotalCartPrice(cart.getTotalCartPrice()+(quantity*product.getProductPrice()));
			cart.setCartItems(itemsList);
			m.addAttribute("cartItems",itemsList);
			cartItemsDao.updateCartItems(cartItems);
		}
		
		cartDao.updateCart(cart);
		
		m.addAttribute(product);
		m.addAttribute(cart);
		
		
		return "redirect:/customer/myCart";
	}
	
	@RequestMapping("myCart")
	public String myCart(Model m, Principal principal)
	{
		Customer customer=customerDao.getCustomerDetails(principal.getName());
		Cart cart = customer.getCart();
		List<CartItems> cartItems = cart.getCartItems();
		
		m.addAttribute("cartItems",cartItems);
		m.addAttribute(cart);
		return "myCart";
	}
	
	@RequestMapping(value="deleteCartItems/{cartItemId}/cartItem")
	public String deleteCartItem(@PathVariable("cartItemId")int id,Model m, Principal p)
	{
		CartItems cartItem = cartItemsDao.getCartItems(id);
		Customer customer = customerDao.getCustomerDetails(p.getName());
		Cart cart = customer.getCart();
		cart.setCartId(cartItem.getCart().getCartId());
	    cart.setCartQuantity(cart.getCartQuantity()-cartItem.getCartItemQuantity());
	    cart.setTotalCartPrice(cart.getTotalCartPrice()-cartItem.getCartItemPrice());
	    
		customer.setCart(cart);
		
		cartDao.updateCart(cart);
		cartItemsDao.deletCartItems(cartItem);
		
		return "redirect:/customer/myCart";
	}
	
}
