package com.happytrip.petcargo.dao;

import java.util.List;

import com.happytrip.petcargo.model.Category;


public interface CategoryDao {
	public void  addCategory(Category category);
    public void  removeCategory(Category category);
    public Category  fetchCategoryById(int categoryId);
    public List<Category>  fetchAllCategory();
    public int getCategoryBySize(String size);
}
