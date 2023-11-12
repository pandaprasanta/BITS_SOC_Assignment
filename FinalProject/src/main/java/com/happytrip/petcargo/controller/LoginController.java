package com.happytrip.petcargo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytrip.petcargo.dao.impl.UserDaoImpl;
import com.happytrip.petcargo.model.Bin;
import com.happytrip.petcargo.model.Category;
import com.happytrip.petcargo.model.User;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@Controller
public class LoginController {
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
	
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}
	
	@RequestMapping("/login")
	public String listBins(Map<String, Object> map,Model model) {
		map.put("user", new User());
		model.addAttribute("mes","Invalid UserId and Password");
		return "userlogin";
	}
	
	@RequestMapping(value="userlogin/check{userId,pass}",method=RequestMethod.POST)
	public String checkLogin(@RequestParam("userId")String uid,@RequestParam("pass")String pas,Model model){
		
		if(uid.equals("kiran") && pas.equals("kumar")){
			return "/searchBin";
		}else if(uid.equals("sameer") && pas.equals("lenka")){
			
			return "/index";	
		}
		else{
			return "redirect:/login";
			//return "loginad";
		}
		
	}
	
}
