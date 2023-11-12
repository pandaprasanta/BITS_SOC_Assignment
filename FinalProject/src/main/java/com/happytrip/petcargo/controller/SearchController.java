package com.happytrip.petcargo.controller;

import java.util.Map;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.happytrip.petcargo.model.Bin;
import com.happytrip.petcargo.model.Category;
import com.happytrip.petcargo.service.AdminService;

@Controller
public class SearchController {

	@Autowired
	AdminService adminService;
	
	//category operation
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
	
	//fetch list of category 
	@RequestMapping("/search")
	public String listCategory(Map<String, Object> map,Model model) {
		map.put("category", new Category());
		model.addAttribute("showcategories",adminService.fetchAllCategory());
		return "showSearch";
	}
	
	@RequestMapping(value = "/showSearch/show{cat}",method = RequestMethod.POST)
	public String deleteBin(@RequestParam("cat")String categoryId,Model model) 
	{
		int id=Integer.parseInt(categoryId);
		model.addAttribute("showbins",adminService.searchBin(id));
		//return "searchResult";
		return "searchResult";
	}

}
