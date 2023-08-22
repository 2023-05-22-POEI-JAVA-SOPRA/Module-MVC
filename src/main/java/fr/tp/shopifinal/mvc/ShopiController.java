package fr.tp.shopifinal.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.tp.shopifinal.entity.Role;
import fr.tp.shopifinal.entity.User;
import fr.tp.shopifinal.service.ArticleService;
import fr.tp.shopifinal.service.RoleService;
import fr.tp.shopifinal.service.UserService;

@Controller
public class ShopiController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	ArticleService articleService;

	@GetMapping("/accueil")
	public ModelAndView accueil() {
		ModelAndView mav = new ModelAndView();
		System.out.println("Page d'accueil");
		mav.setViewName("accueil");
		return mav;
	}

	@GetMapping("/users")
	public ModelAndView usersList() {
		ModelAndView mav = new ModelAndView();
		System.out.println("Page des users");
		mav.setViewName("users");
		mav.addObject("users", userService.getUserDao().findAll());
		return mav;
	}

	@GetMapping("/roles")
	public ModelAndView rolesList() {
		ModelAndView mav = new ModelAndView();
		System.out.println("Page des roles");
		mav.setViewName("roles");
		mav.addObject("roles", roleService.findAll());
		return mav;
	}

	@GetMapping("/articles")
	public ModelAndView articlesList() {
		ModelAndView mav = new ModelAndView();
		System.out.println("Page des articles");
		mav.setViewName("articles");
		mav.addObject("articles", articleService.findAll());
		return mav;
	}

	@GetMapping("/users/search")
	public ModelAndView searchUserByLogin(@RequestParam(value = "login") String login) {
		ModelAndView mav = new ModelAndView();
		System.out.println("recherche users...");
		mav.setViewName("search");
		mav.addObject("users", userService.findByLogin(login));
		return mav;
	}

	@GetMapping("/roles/search")
	public ModelAndView searchRoleByName(@RequestParam(value = "name") String name) {
		ModelAndView mav = new ModelAndView();
		System.out.println("recherche roles...");
		mav.setViewName("search");
		mav.addObject("roles", roleService.findByNameContainingIgnoreCase(name));
		return mav;
	}

	@GetMapping("/articles/search")
	public ModelAndView searchArticleByDescription(@RequestParam(value = "description") String description) {
		ModelAndView mav = new ModelAndView();
		System.out.println("recherche articles...");
		mav.setViewName("search");
		mav.addObject("articles", articleService.findByDescriptionContaining(description));
		return mav;
	}

	@RequestMapping("/users/delete/{id}")
	public ModelAndView deleteUserById(@PathVariable String id) {
		ModelAndView mav = new ModelAndView();
		System.out.println("delete user...");
		mav.setViewName("delete");
		userService.deleteById(Long.parseLong(id));
		return mav;
	}

	@RequestMapping("/roles/delete/{id}")
	public ModelAndView deleteRolerById(@PathVariable String id) {
		ModelAndView mav = new ModelAndView();
		System.out.println("delete role...");
		mav.setViewName("delete");
		roleService.deleteById(Long.parseLong(id));
		return mav;
	}

	@RequestMapping("/articles/delete/{id}")
	public ModelAndView deleteArticlerById(@PathVariable String id) {
		ModelAndView mav = new ModelAndView();
		System.out.println("delete article...");
		mav.setViewName("delete");
		articleService.deleteById(Long.parseLong(id));
		return mav;
	}

	@GetMapping("/users/modify/{id}")
	public ModelAndView modifyUser(@PathVariable String id) {
		ModelAndView mav = new ModelAndView();
		System.out.println("modification user...");
		mav.setViewName("modifyUser");
		mav.addObject("user", userService.findById(Long.parseLong(id)));
		return mav;
	}

	@PostMapping("/users/modify/{id}")
	public ModelAndView saveModifyUser(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView();
		System.out.println("User modifié!");
		mav.setViewName("redirect:/users");
		mav.addObject("user", user);
		userService.save(user);
		return mav;
	}
	
	@GetMapping("/roles/modify/{id}")
	public ModelAndView modifyRole(@PathVariable String id) {
		ModelAndView mav = new ModelAndView();
		System.out.println("modification role...");
		mav.setViewName("modifyRole");
		mav.addObject("role", roleService.findById(Long.parseLong(id)));
		return mav;
	}

	@PostMapping("/roles/modify/{id}")
	public ModelAndView saveModifyRole(@ModelAttribute("role") Role role) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Role modifié!");
		mav.setViewName("redirect:/roles");
		mav.addObject("role", role);
		roleService.save(role);
		return mav;
	}

}
