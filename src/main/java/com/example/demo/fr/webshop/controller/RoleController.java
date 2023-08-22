package com.example.demo.fr.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.fr.webshop.service.RoleService;


@Controller
public class RoleController {

	
	@Autowired
	RoleService roleService;
	
	

	@GetMapping(path = {"/roles", "/roles.html"})
	public ModelAndView afficheRoles() {
		 System.out.println("J'affiche la page roles");

		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("roles");
		 mav.addObject("roles", roleService.getAll());
		 
		 return mav;
	}
	

	@GetMapping("/roles/find")
	public ModelAndView sauvegardePlanete(@RequestParam(value = "partialName") String partialName) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/roles");
		mav.addObject("roles", roleService.getByNameLike(partialName));

		return mav;
	}
	
	
}
