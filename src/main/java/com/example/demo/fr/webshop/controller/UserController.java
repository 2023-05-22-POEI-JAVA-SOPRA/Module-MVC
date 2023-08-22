package com.example.demo.fr.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.fr.webshop.service.UserService;


@Controller
public class UserController {

	
	@Autowired
	UserService userService;

	@GetMapping(path = {"/users", "/users.html"})
	public ModelAndView afficheUsers() {
		 System.out.println("J'affiche la page users");

		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("users");
		 mav.addObject("users", userService.getAll());
		 
		 return mav;
	}
	

	@GetMapping("/users/find")
	public ModelAndView sauvegardePlanete(@RequestParam(value = "partialLogin") String partialLogin) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/users");
		mav.addObject("users", userService.getByPartialLogin(partialLogin));

		return mav;
	}
	
	
}
