package com.happytrip.petcargo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytrip.petcargo.dao.BinDao;
import com.happytrip.petcargo.dao.CategoryDao;
import com.happytrip.petcargo.model.Bin;
import com.happytrip.petcargo.model.Category;
import com.happytrip.petcargo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private BinDao binDao;
	
	@Override
	public void addCategory(Category category) {
		categoryDao.addCategory(category);	
	}

	@Override
	public void removeCategory(Category category) {
		categoryDao.removeCategory(category);
		
	}

	@Override
	public Category fetchCategoryById(int categoryId) {
		Category category = new Category();
		category = categoryDao.fetchCategoryById(categoryId);
		return category;
	}

	@Override
	public List<Category> fetchAllCategory() {
		return categoryDao.fetchAllCategory();
	}

	@Override
	public void addBin(Bin bin,int id) {
		binDao.addBin(bin,id);
	}

	@Override
	public List<Bin> searchBin(int categoryId) {
		List<Bin> bins = new ArrayList<>();
		bins = binDao.searchBin(categoryId);
		return bins;
	}

	@Override
	public Bin fetchBinById(int binId) {
		Bin bin = new Bin();
		bin = binDao.fetchBinById(binId);
		return bin;
	}

	@Override
	public void removeBin(Bin bin) {
		binDao.removeBin(bin);
	}
    @Override
    public List<Bin> fetchAllBins() {
        return binDao.fetchAllBins();
    }
    @Override
    public int getCategoryBySize(String size) {
    	return categoryDao.getCategoryBySize(size); 
    }
}
