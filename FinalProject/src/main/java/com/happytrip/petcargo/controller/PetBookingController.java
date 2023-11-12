package com.happytrip.petcargo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.happytrip.petcargo.model.Pet;
import com.happytrip.petcargo.service.AdminService;

@Controller
public class PetBookingController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	HttpSession session;
	
	@ModelAttribute("bin")
	public Bin getBin(){
		return new Bin();
   }
	@ModelAttribute("pet1")
	public Pet getPet(){
		return new Pet();
   }
	
	@RequestMapping("/book")
	public String listBins(Map<String, Object> map,Model model) {
			map.put("bin", new Bin());
			
			return "showSearch/bookBin";
	}
	@RequestMapping(value = "/showSearch/bookBin/add{x}",method = RequestMethod.POST)
	public String addBin(@RequestParam("x")String id,@ModelAttribute("bin")Bin bin,BindingResult result) 
	{

		int val=Integer.parseInt(id);
	    System.out.println("bin booked successfully"+val);
	    session.setAttribute("binPrice",adminService.fetchBinById(val));
		return "petinfo";
	}		
}
