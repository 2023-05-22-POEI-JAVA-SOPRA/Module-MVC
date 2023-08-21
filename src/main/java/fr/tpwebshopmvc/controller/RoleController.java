package fr.tpwebshopmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.tpwebshopmvc.model.Role;
import fr.tpwebshopmvc.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public ModelAndView showRoles()
	{
		System.out.println("roles ");
		List<Role> allRoles = roleService.findAll();
		return new ModelAndView("roles","roles",allRoles);
	}
	
}
