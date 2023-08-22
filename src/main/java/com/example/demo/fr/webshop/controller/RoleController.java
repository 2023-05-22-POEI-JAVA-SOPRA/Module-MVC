package com.example.demo.fr.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.fr.webshop.service.RoleService;


@Controller
public class RoleController {

	
	@Autowired
	RoleService roleService;
	
	

	@GetMapping(path = {"/roles", "/roles.html"})
	public ModelAndView afficheRoles(@RequestParam(value = "partialName", required = false) String partialName) {
		 System.out.println("J'affiche la page roles");

		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("roles");
		 
		 if(partialName==null) {
			 mav.addObject("roles", roleService.getAll());
			 return mav;
		 } else {
			 mav.addObject("roles", roleService.getByNameLike(partialName));
			 return mav;			 
		 }
	}
	
	
	@RequestMapping(path = "/roles/{id}")
	public ModelAndView deleteRole(@PathVariable(value = "id") Long id) {
		System.out.println("Méthode deleteRole appelée");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/roles");
		 
		roleService.delete(id);
		
		return mav;
	}
	
	
}
