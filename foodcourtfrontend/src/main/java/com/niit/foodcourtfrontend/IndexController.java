package com.niit.foodcourtfrontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
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
	public ModelAndView index(Model m)
	{
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return new ModelAndView("index");
	}

	
	@RequestMapping("/register")
	public ModelAndView register(Model m)
	{
		Customer customer=new Customer();
		m.addAttribute(customer);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer customer, Model m)
	{
		
		customerDao.addCustomer(customer);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return "index";
		
	}

	@RequestMapping("/product")
	public ModelAndView product(Model m)
	{
		Product product = new Product();
		m.addAttribute(product);

		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		
		return new ModelAndView("product");
	}
	
	@RequestMapping(value = "/prodProcess", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product , @RequestParam("pimage") MultipartFile file, Model m, BindingResult result)
	{
		
		productDao.addProduct(product);
		
		String path = "E:/eclipse examples/foodcourtfrontend/src/main/webapp/resources/";
		
		String totalFilewithPath = path+String.valueOf(product.getProductId())+".jpg";
		
		File productImage = new File(totalFilewithPath);
		
		if(!file.isEmpty())
		{
			try {
				byte fileBuffer[]= file.getBytes();
				FileOutputStream fos = new FileOutputStream(productImage);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("File Exception",e);
			}
		}
		
		else {
			m.addAttribute("error","problem in uploading image");
		}
				
		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		
		return new ModelAndView("product");
		
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
	
	/*@RequestMapping(value = "/CategorizedProducts/catId", method = RequestMethod.GET)
	public ModelAndView products(@PathVariable int catId, Model m) {
	
		
		List<Product> products = (List<Product>) productDao.getProduct(catId);
		m.addAttribute("catprodlist", products);
		return new ModelAndView("CategorizedProducts");
	}
	
	*/
}
