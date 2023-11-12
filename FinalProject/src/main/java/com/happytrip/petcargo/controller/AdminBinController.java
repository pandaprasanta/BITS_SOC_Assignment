package com.happytrip.petcargo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytrip.petcargo.model.Bin;
import com.happytrip.petcargo.model.Category;

import com.happytrip.petcargo.service.AdminService;

@Controller
public class AdminBinController {

	@Autowired
	AdminService adminService;
	//Bin Operation
		@ModelAttribute("bin")
		public Bin getBin(){
			return new Bin();
		}
		
		//fetch list of Bins 
		@RequestMapping("/index1")
		public String listBins(Map<String, Object> map,Model model) {
			map.put("bin", new Bin());
			//map.put("binlist", adminService.fetchAllBins());
			//model.addAttribute("message",adminService.fetchAllBins());
			model.addAttribute("message",adminService.fetchAllBins());
			//System.out.println("hin bin ret");
			return "addBin";
		}

		//addCategory
		@RequestMapping(value = "/addBin/add",method = RequestMethod.POST)
		public String addBin(@ModelAttribute("bin")Bin bin,BindingResult result) 
		{
			//System.out.println(adminService.getCategoryBySize("2X2"));
			int id=adminService.getCategoryBySize(bin.getBinSize());
			//System.out.println(id);
			if(id!=0)
				adminService.addBin(bin,id);
			return "redirect:/index1";
		}
		//delete Bins
		@RequestMapping(value = "/addBin/delete{bin11}",method = RequestMethod.POST)
		public String deleteBin(@RequestParam("bin11")String categoryId) 
		{
			int id=Integer.parseInt(categoryId);
			Bin bin1=adminService.fetchBinById(id);
//			System.out.println("Bin"+bin1.getBinId());
//			System.out.println("Bin"+bin1.getBinName());
			adminService.removeBin(bin1);
			//adminService.removeCategory(adminService.fetchCategoryById(Integer.parseInt(categoryId)));
			return "redirect:/index1";
		}
	
}
