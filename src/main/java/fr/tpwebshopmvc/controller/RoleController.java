package fr.tpwebshopmvc.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.tpwebshopmvc.model.Role;

import fr.tpwebshopmvc.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/roles")
	public ModelAndView showRoles() {
		System.out.println("roles ");
		Iterable<Role> allRoles = roleService.findAll();
		return new ModelAndView("roles", "roles", allRoles);
	}

	@GetMapping("/roles/create")
	public ModelAndView showFormRole() {
		Role emptyRole = new Role();
		return new ModelAndView("addRole", "role", emptyRole);
	}
	@PostMapping("/roles/updateRole")
	public ModelAndView update(@Validated @ModelAttribute("role") Role role, BindingResult bindingResult) {
		System.out.println("update role : " + role);
		if (bindingResult.hasErrors()) {
			System.out.println("Erreur dans l'update  de role");
			ModelAndView mv = new ModelAndView();
			mv.addObject("role", role);
			mv.setViewName("updateRole");
			mv.addObject("errorString", "Erreur dans la sauvegarde de l'utilisateur");
			return mv;
		} else {
			roleService.updateRole(role);
			System.out.println("Role with id " + role + " updated");
		}
		return new ModelAndView("redirect:/roles");

	}
	

	@GetMapping("/roles/update")
	public ModelAndView getRole(@RequestParam("id") Integer id) {
		System.out.println("get roles by id : " + id);
		 Role roleInDb = roleService.findById(id);
		return new ModelAndView("updateRole", "role", roleInDb);
	}

	@GetMapping("/roles/search") // http://localhost:8080/tpwebshopmvc/users/search/rip
	public ModelAndView filterUserPathParam(@RequestParam("searchByRoleName") String searchByRoleName) {
		System.out.println("roles filter by rolename ");
		List<Role> rolesFiltered = roleService.getByRoleNameLike(searchByRoleName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("roles");
		mv.addObject("searchByRoleName", searchByRoleName);
		mv.addObject("roles", rolesFiltered);
		return mv;
	}
	@PostMapping("/roles/saveRole")
	public ModelAndView save(@Validated @ModelAttribute("role") Role role, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("Erreur dans la sauvegarde du role");
			ModelAndView mv = new ModelAndView();
			mv.addObject("role", role);
			mv.setViewName("addRole");
			mv.addObject("errorString", "Erreur dans la sauvegarde du role");
			return mv;
		} else {
			System.out.println("Save role");
			roleService.save(role);
		}
		return new ModelAndView("redirect:/roles");
	}

	
	@GetMapping("/roles/delete") // http://localhost:8080/tpwebshopmvc/roles/delete?id=1
	public ModelAndView deleteRole(@RequestParam("id") Integer id) {
		System.out.println("roles delete by id : " + id);
		roleService.deleteById(id);
		return new ModelAndView("redirect:/roles");
	}
}