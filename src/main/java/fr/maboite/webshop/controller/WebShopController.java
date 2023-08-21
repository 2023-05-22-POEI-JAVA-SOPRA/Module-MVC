package fr.maboite.webshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.maboite.webshop.model.Article;
import fr.maboite.webshop.model.Role;
import fr.maboite.webshop.model.User;
import fr.maboite.webshop.service.ArticleService;
import fr.maboite.webshop.service.RoleService;
import fr.maboite.webshop.service.UserService;

@Controller
public class WebShopController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping("/webshop")
	public ModelAndView showWelcomePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index");
		return mav;
	}
	
	@GetMapping("/webshop/user")
	public ModelAndView showUserPage() {
		Iterable<User> users = this.userService.getAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user");
		mav.addObject("users",users);
		return mav;
	}
	
	@GetMapping("/webshop/user/search")
	public ModelAndView FindUserByLogin(@RequestParam(value="partLogin") String partLogin) {
		List<User> users = this.userService.findByLoginContainingIgnoreCase(partLogin);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user");
		mav.addObject("partLogin",partLogin);
		mav.addObject("users",users);
		return mav;
	}
	
	@PostMapping("/webshop/user/delete")
	public ModelAndView DeleteUser(@RequestParam(value ="idUser") Long idUser) {
		Optional<User> user = this.userService.getById(idUser);
		this.userService.delete(idUser);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user");
		mav.addObject(idUser);
		mav.addObject("user",user);
		return mav;
	}
	
	@GetMapping("/webshop/role")
	public ModelAndView showRolePage() {
		Iterable<Role> roles = this.roleService.getAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/role");
		mav.addObject("roles",roles);
		return mav;
	}
	
	@GetMapping("/webshop/role/search")
	public ModelAndView FindRoleByName(@RequestParam(value="partName") String partName) {
		List<Role> roles = this.roleService.findByNameContainsIgnoreCase(partName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/role");
		mav.addObject("partName",partName);
		mav.addObject("roles",roles);
		return mav;
	}
	
	@GetMapping("/webshop/article")
	public ModelAndView showArticlePage() {
		Iterable<Article> articles = this.articleService.getAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/article");
		mav.addObject("articles",articles);
		return mav;
	}
	
	@GetMapping("/webshop/article/search")
	public ModelAndView FindArticleByDescription(@RequestParam(value="partDescription") String partDescription) {
		List<Article> articles = this.articleService.findByDescriptionContainsIgnoreCase(partDescription);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/article");
		mav.addObject("partDescription",partDescription);
		mav.addObject("articles",articles);
		return mav;
	}
	
}
