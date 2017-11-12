package com.niit.foodcourtfrontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.niit.foodcourtbackend.Product;
import com.niit.foodcourtbackend.dao.CategoryDao;
import com.niit.foodcourtbackend.dao.CustomerDao;
import com.niit.foodcourtbackend.dao.ProductDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

	@RequestMapping("/product")
	public ModelAndView product(Model m) {
		Product product = new Product();
		m.addAttribute(product);

		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);

		return new ModelAndView("product");
	}

	@RequestMapping(value = "/prodProcess", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, @RequestParam("pimage") MultipartFile file,
			Model m, BindingResult result, HttpServletRequest request) {

		System.err.println("productId" + product.getProductId());

		if (product.getProductId() != 0) {
			productDao.updateProduct(product);
		} else
			productDao.addProduct(product);

		String path = request.getServletContext().getRealPath("/resources/");

		String totalFilewithPath = path + String.valueOf(product.getProductId()) + ".jpg";

		File productImage = new File(totalFilewithPath);

		if (!file.isEmpty()) {
			try {
				byte fileBuffer[] = file.getBytes();
				FileOutputStream fos = new FileOutputStream(productImage);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();
			} catch (Exception e) {
				m.addAttribute("File Exception", e);
			}
		}

		else {
			m.addAttribute("error", "problem in uploading image");
		}

		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);

		return "redirect:/admin/product";

	}

	@RequestMapping("/category")
	public ModelAndView categories(Model m) {
		Category category = new Category();
		m.addAttribute(category);

		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return new ModelAndView("category");
	}

	@RequestMapping(value = "/catProcess", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model m) {
		System.err.println("catId" + category.getCatId());

		if (category.getCatId() != 0) {
			categoryDao.updateCategory(category);
		} else
			categoryDao.addCategory(category);

		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return "redirect:/admin/category";

	}

	@RequestMapping(value = "updateProduct/{productId}")
	public ModelAndView editProduct(@PathVariable("productId") int productId, Model m) {
		Product product = productDao.getProduct(productId);
		m.addAttribute("product", product);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		return new ModelAndView ("product");
	}

	@RequestMapping(value = "deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId, Model m) {
		Product p = productDao.getProduct(productId);
		productDao.deleteProduct(p);
		Product product = new Product();
		m.addAttribute("product", product);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		List<Product> listProducts = productDao.retreiveAllProducts();
		m.addAttribute("prodlist", listProducts);
		return "redirect:/admin/product";
	}

	@RequestMapping(value = "updateCategory/{catId}")
	public String updateCategory(@PathVariable("catId") int catId, Model m) {
		Category c = categoryDao.getCategory(catId);
		m.addAttribute("category", c);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return "category";
	}

	@RequestMapping(value = "deleteCategory/{catId}")
	public String deleteCategory(@PathVariable("catId") int catId, Model m) {

		Category c = categoryDao.getCategory(catId);
		categoryDao.deletCategory(c);
		Category category = new Category();
		m.addAttribute(category);
		List<Category> listcategories = categoryDao.retreiveAllCategories();
		m.addAttribute("catlist", listcategories);
		return "redirect:/admin/category";
	}
}
