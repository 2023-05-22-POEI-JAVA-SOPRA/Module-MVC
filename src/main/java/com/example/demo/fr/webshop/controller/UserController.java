package com.example.demo.fr.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.fr.webshop.service.UserService;


@Controller
public class UserController {

	
	@Autowired
	UserService userService;

	@GetMapping(path = {"/users", "/users.html"})
	public ModelAndView afficheUsers(@RequestParam(value = "partialLogin", required = false) String partialLogin) {
		 System.out.println("J'affiche la page users");

		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("users");
		 
		 if(partialLogin==null) {
			 mav.addObject("users", userService.getAll());
			 return mav;
		 } else {
			 mav.addObject("users", userService.getByPartialLogin(partialLogin));
			 return mav;
		 }
		 
	}
	
	
	@RequestMapping(path = "/users/{id}")
	public ModelAndView deleteUser(@PathVariable(value = "id") Long id) {
		System.out.println("Méthode deleteUser appelée");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/users");
		 
		userService.delete(id);
		
		return mav;
	}
	
	
}
