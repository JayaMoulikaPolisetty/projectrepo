package com.niit.foodcourtbackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.foodcourtbackend.Category;

@Component
public interface CategoryDao {

	boolean addCategory(Category category);
	boolean deletCategory(Category category);
	boolean updateCategory(Category category);
	Category getCategory(Integer id);
	List<Category> retreiveAllCategories();
}
