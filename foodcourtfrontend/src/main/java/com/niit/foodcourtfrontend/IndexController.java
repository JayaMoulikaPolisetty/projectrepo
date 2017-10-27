package com.niit.foodcourtfrontend;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.foodcourtbackend.Category;
import com.niit.foodcourtbackend.Customer;
import com.niit.foodcourtbackend.Product;
import com.niit.foodcourtbackend.dao.CategoryDao;
import com.niit.foodcourtbackend.dao.CustomerDao;
import com.niit.foodcourtbackend.dao.ProductDao;

@Controller
public class IndexController {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		
		return new ModelAndView("index");
	}

	
	@RequestMapping("/register")
	public ModelAndView register(Model m)
	{
		Customer customer=new Customer();
		m.addAttribute(customer);
		return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer customer, Model m)
	{
		
		customerDao.addCustomer(customer);
		
		return "index";
		
	}

	@RequestMapping("/product")
	public ModelAndView products(Model m)
	{
		Product product = new Product();
		m.addAttribute(product);

		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		return new ModelAndView("product");
	}
	
	@RequestMapping(value = "/prodProcess", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, Model m)
	{
		
		productDao.addProduct(product);
		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		return "product";
		
	}
	
	@RequestMapping("/category")
	public ModelAndView categories(Model m)
	{
		Category category=new Category();
		m.addAttribute(category);

		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return new ModelAndView("category");
	}

	@RequestMapping(value = "/catProcess", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model m)
	{
		
		categoryDao.addCategory(category);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return "category";
		
	}
	
}