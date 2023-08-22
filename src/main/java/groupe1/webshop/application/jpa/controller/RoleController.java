package groupe1.webshop.application.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import groupe1.webshop.application.jpa.entity.Role;
import groupe1.webshop.application.jpa.service.serviceRole;

@Controller
public class RoleController {
	
	@Autowired
	private serviceRole sRole;
	
	@GetMapping(path = "/roles")
	public ModelAndView searchRoles(@RequestParam(name="recherche",required=false)String descr) {
		System.out.println("Méthode sur /roles appelée");
		// return des roles pour planetes.html (cf. config pour prefix/suffix)
		ModelAndView mav=new ModelAndView();
		mav.setViewName("roles");
		if(descr==null) {
			//System.out.println("descr null");
			mav.addObject("maListeRole", sRole.getAll());
			return mav;
		}
		else {	
			System.out.println("descr panul");
			mav.addObject("maListeRole", sRole.getByRoleName(descr));
			return mav;
		}
	}
	
	@PostMapping("/delete-role")
	public String deleteRole(Integer id) {
		sRole.deleteById(id);
		System.out.println("on supprime : " + id);
		return "redirect:/roles"; // Redirection sur la page de base
	}
	
	// PAGE EDIT ROLE
	
	@GetMapping("/role-edit")
	public ModelAndView afficheEditRole(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Role role = sRole.getById(id).get();
		mav.setViewName("roleEdit");
		mav.addObject("editedRole", role);
		return mav;
	}
	
	@PostMapping("/role-edit")
	public ModelAndView editRole(@Validated @ModelAttribute("editedRole") Role role,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/roles"); // nom de la vue (page html)
			mav.addObject("editedRole", role); // nom du mlodel attribute et valeur de l'object
			System.out.println("Erreur de role, je ne sauvegarde pas.");
			mav.addObject("errorString", "Erreur dans le role !");
			return mav;
		}
		ModelAndView mav = new ModelAndView();
		sRole.save(role);
		System.out.println(role.toString());
		mav.setViewName("redirect:/roles"); // nom de la vue (page html)
		mav.addObject("editedRole", role); // nom du mlodel attribute et valeur de l'object
		return mav;
	}
	
	@GetMapping("/role-create")
	public ModelAndView afficheCreateRole() {
		ModelAndView mav = new ModelAndView();
		Role newRole = new Role();
		mav.setViewName("roleCreate");
		mav.addObject("newRole", newRole);
		return mav;
	}
	
	// PAGE CREATE ROLE
	@PostMapping("/role-create")
	public ModelAndView createRole(@Validated @ModelAttribute("createRole") Role newRole
			,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/roles"); // nom de la vue (page html)
			mav.addObject("newRole", newRole); // nom du mlodel attribute et valeur de l'object
			System.out.println("Erreur creation role, je ne cree pas.");
			mav.addObject("errorString", "Erreur dans la creation du role !");
			return mav;
		}
		ModelAndView mav = new ModelAndView();
		sRole.save(newRole);
		mav.setViewName("redirect:/roles");
		mav.addObject("newRole", newRole); // nom du model attribute et valeur de l'object
		return mav;

	}
	
}
