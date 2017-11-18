package com.niit.foodcourtfrontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.foodcourtbackend.Cart;
import com.niit.foodcourtbackend.Category;
import com.niit.foodcourtbackend.Customer;
import com.niit.foodcourtbackend.Product;
import com.niit.foodcourtbackend.dao.CartDao;
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

	@Autowired
	CartDao cartDao;

	@Autowired
	HttpSession session;

	@RequestMapping({ "/", "/home" })
	public ModelAndView index(Model m, Principal principal) {

		if (principal != null) {

			Customer customer = customerDao.getCustomerDetails(principal.getName());

			if (customer.getRole() != "ROLE_ADMIN") {
				Cart cart = customer.getCart();
				m.addAttribute(cart);
				m.addAttribute(customer);
			}

		} else {
			System.out.println("not loggedin");
		}
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);

		return new ModelAndView("index");
	}

	@RequestMapping("/register")
	public ModelAndView register(Model m) {
		Customer customer = new Customer();
		m.addAttribute(customer);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(customer);
			return "register";
		} else {
			if (!(customer.getPassword().equals(customer.getConfirmPassword()))) {
				m.addAttribute(customer);
				m.addAttribute("errorPass", "passwords should match");
				return "register";
			} else {
				Cart cart = new Cart();
				customer.setCart(cart);
				cart.setCustomer(customer);
				customerDao.addCustomer(customer);
				cartDao.addCart(cart);
				List<Category> listcategories = categoryDao.retreiveAllCategories();
				m.addAttribute("catlist", listcategories);
				return "redirect:/";
			}
		}

	}

	@RequestMapping(value = "/login")
	public String login(Model m) {

		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return "login";
	}

	@RequestMapping("/products")
	public ModelAndView product(Model m, Principal principal) {

		if (principal != null) {

			Customer customer = customerDao.getCustomerDetails(principal.getName());
			Cart cart = customer.getCart();
			m.addAttribute(cart);
			m.addAttribute(customer);
		}

		Product product = new Product();
		m.addAttribute(product);

		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);

		return new ModelAndView("products");
	}

	@RequestMapping(value = "/CategorizedProducts/{catId}", method = RequestMethod.GET)
	public ModelAndView products(@PathVariable("catId") int catId, Model m, Principal principal) {

		if (principal != null) {

			Customer customer = customerDao.getCustomerDetails(principal.getName());
			Cart cart = customer.getCart();
			m.addAttribute(cart);
			m.addAttribute(customer);
		}
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		Category cat = categoryDao.getCategory(catId);
		Collection<Product> products = cat.getProducts();
		m.addAttribute("catprodlist", products);
		return new ModelAndView("CategorizedProducts");
	}

	@RequestMapping(value = "/productDisplay/{productId}", method = RequestMethod.GET)
	public ModelAndView prodDisplay(@PathVariable("productId") int productId, Model m, Principal principal) {

		if (principal != null) {

			Customer customer = customerDao.getCustomerDetails(principal.getName());
			Cart cart = customer.getCart();
			m.addAttribute(cart);
			m.addAttribute(customer);
		}
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		Product product = productDao.getProduct(productId);
		m.addAttribute(product);
		return new ModelAndView("productDisplay");
	}

}
