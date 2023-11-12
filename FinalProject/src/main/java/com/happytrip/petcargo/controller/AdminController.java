package com.happytrip.petcargo.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.happytrip.petcargo.model.Bin;
import com.happytrip.petcargo.model.Category;
import com.happytrip.petcargo.service.AdminService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	//category operation
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
	
	//fetch list of category 
	@RequestMapping("/index")
	public String listCategory(Map<String, Object> map,Model model) {
		map.put("category", new Category());
		//map.put("categorylist", adminService.fetchAllCategory());
		model.addAttribute("message",adminService.fetchAllCategory());
		//model.addAttribute("message",adminService.fetchAllBins());
		return "addCategory";
	}

	//addCategory
	@RequestMapping(value = "/addCategory/add",method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category")Category category, BindingResult result) 
	{
		//System.out.println("hi");
		adminService.addCategory(category);
		return "redirect:/index";
	}
	//delete category
	@RequestMapping(value = "/addCategory/delete{cat}",method = RequestMethod.POST)
	public String deleteCategory(@RequestParam("cat")String categoryId) 
	{
		int id=Integer.parseInt(categoryId);
		Category category=adminService.fetchCategoryById(id);
//		System.out.println(category.getCategoryId());
//		System.err.println(category.getCategorySize());
		adminService.removeCategory(category);
		//adminService.removeCategory(adminService.fetchCategoryById(Integer.parseInt(categoryId)));
		return "redirect:/index";
	}
	
}
