package com.happytrip.petcargo.service;

import java.util.List;

import com.happytrip.petcargo.model.Bin;
import com.happytrip.petcargo.model.Category;

public interface AdminService {
//Category Operation
	public void  addCategory(Category category);
    public void  removeCategory(Category category);
    public Category  fetchCategoryById(int categoryId);
    public List<Category>  fetchAllCategory();
    public int getCategoryBySize(String size);
    
//BinOperation
    public void addBin(Bin bin,int id);
    public List<Bin> searchBin(int categoryId);
    public Bin fetchBinById(int binId);
    public void removeBin(Bin bin);
    public List<Bin> fetchAllBins();
}
