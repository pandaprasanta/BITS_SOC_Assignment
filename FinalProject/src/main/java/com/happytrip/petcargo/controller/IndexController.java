package com.happytrip.petcargo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happytrip.petcargo.model.User;
@Controller
public class IndexController {
	// @RequestMapping("/userlogin/check")
	@RequestMapping("")
	public String listBins(Map<String, Object> map,Model model) {
		map.put("user", new User());
		model.addAttribute("mes","Invalid UserId and Password");
		return "index";
	}
}
