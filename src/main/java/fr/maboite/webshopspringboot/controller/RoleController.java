package fr.maboite.webshopspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.maboite.webshopspringboot.model.Role;
import fr.maboite.webshopspringboot.service.RoleService;
import jakarta.validation.Valid;

@Controller
public class RoleController {
	
	private RoleService roleService;
	

	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	
	@GetMapping("/roles")
	public String listRoles(Model model, @RequestParam(value = "searchName", required = false) String searchName) {
	    List<Role> roles;

	    if (searchName != null && !searchName.isEmpty()) {
	        roles = roleService.getRolesByNameContainingIgnoreCase(searchName);
	    } else {
	        roles = roleService.getAllRoles();
	    }

	    model.addAttribute("roles", roles);
	    model.addAttribute("searchName", searchName);

	    return "roles";
	}

	 
	 @GetMapping("/role/create")
	 public String showCreateRoleForm(Model model) {
	     model.addAttribute("role", new Role());
	     return "createRole";
	 }
	 
	 @GetMapping("/role/edit/{id}")
	 public String showEditRoleForm(@PathVariable Integer id, Model model) {
	     Role role = roleService.getRoleById(id);
	     model.addAttribute("role", role);
	     return "editRole";
	 }
	 
	 @GetMapping("/role/delete/{id}")
	 public String showDeleteRoleForm(@PathVariable Integer id, Model model) {
	     Role role = roleService.getRoleById(id);
	     model.addAttribute("role", role);
	     return "deleteRole";
	 }
	 
	 @PostMapping("/role/delete/{id}")
	 public String deleteRole(@PathVariable Integer id) {
	     roleService.deleteRole(id);
	     return "redirect:/roles"; 
	 }


	 
	 @PostMapping("/role")
	 public String saveRole(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult) {
	     if (bindingResult.hasErrors()) {
	    	 System.out.println("Erreurs de validation détectées.");
	         return "createRole"; 
	     } else {
	         roleService.saveRole(role);
	         return "redirect:/roles"; 
	     }
	  
	     
	     
	 }


	 
	 

}
