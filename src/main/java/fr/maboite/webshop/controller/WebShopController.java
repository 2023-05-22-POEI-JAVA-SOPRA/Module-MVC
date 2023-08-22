package fr.maboite.webshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.maboite.webshop.model.Article;
import fr.maboite.webshop.model.Command;
import fr.maboite.webshop.model.Role;
import fr.maboite.webshop.model.User;
import fr.maboite.webshop.service.ArticleService;
import fr.maboite.webshop.service.CommandService;
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
	
	@Autowired
	CommandService commandService;
	
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
	
	@GetMapping("/webshop/user/delete/{idUser}")
	public ModelAndView DeleteUser(@PathVariable("idUser") Long idUser) {
		this.userService.delete(idUser);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/webshop/user");
		return mav;
	}
	
	@GetMapping("/webshop/user/save/{idUser}")
	public ModelAndView UpdateUser(@PathVariable("idUser") Long idUser) {
		User user = this.userService.getById(idUser);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user-save");
		mav.addObject("user",user);
		return mav;
	}
	
	@PostMapping("/webshop/user/save")
	public ModelAndView SaveUser(@Validated @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("user-save");
			mav.addObject("user", user);
			System.out.println("Erreur d'utilisateur, je ne sauvegarde pas.");
			mav.addObject("errorString", "Erreur dans l'utilisateur!!!");
			return mav;
		}else {
		this.userService.save(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/webshop/user");
		mav.addObject("user",user);
		return mav;
		}
	}
	
	@GetMapping("/webshop/user/create")
	public ModelAndView CreateUser() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user-save");
		mav.addObject("user",new User());
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
	
	@GetMapping("/webshop/role/delete/{idRole}")
	public ModelAndView DeleteRole(@PathVariable("idRole") Long idRole) {
		this.roleService.delete(idRole);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/webshop/role");
		return mav;
	}
	
	@GetMapping("/webshop/role/save/{idRole}")
	public ModelAndView UpdateRole(@PathVariable("idRole") Long idRole) {
		Role role = this.roleService.getById(idRole);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/role-save");
		mav.addObject("role",role);
		return mav;
	}
	
	@PostMapping("/webshop/role/save")
	public ModelAndView SaveRole(@Validated @ModelAttribute("role") Role role, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("role-save");
			mav.addObject("role", role);
			System.out.println("Erreur de rôle, je ne sauvegarde pas.");
			mav.addObject("errorString", "Erreur dans le rôle!!!");
			return mav;
		}else {
		this.roleService.save(role);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/webshop/role");
		mav.addObject("role",role);
		return mav;
		}
	}
	
	@GetMapping("/webshop/role/create")
	public ModelAndView CreateRole() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/role-save");
		mav.addObject("role",new Role());
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
	
	@GetMapping("/webshop/article/delete/{idArticle}")
	public ModelAndView DeleteArticle(@PathVariable("idArticle") Long idArticle) {
		this.articleService.delete(idArticle);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/webshop/article");
		return mav;
	}
	
	@GetMapping("/webshop/article/save/{idArticle}")
	public ModelAndView UpdateArticle(@PathVariable("idArticle") Long idArticle) {
		Article article = this.articleService.getById(idArticle);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/article-save");
		mav.addObject("article",article);
		return mav;
	}
	
	@PostMapping("/webshop/article/save")
	public ModelAndView SaveArticle(@Validated @ModelAttribute("article") Article article, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("article-save");
			mav.addObject("article", article);
			System.out.println("Erreur d'article, je ne sauvegarde pas.");
			mav.addObject("errorString", "Erreur dans l'article!!!");
			return mav;
		}else {
		this.articleService.save(article);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/webshop/article");
		mav.addObject("article",article);
		return mav;
		}
	}
	
	@GetMapping("/webshop/article/create")
	public ModelAndView CreateArticle() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/article-save");
		mav.addObject("article",new Article());
		return mav;
	}
	
	@GetMapping("/webshop/command")
	public ModelAndView showCommandPage() {
		Iterable<Command> commands = this.commandService.getAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/command");
		mav.addObject("commands",commands);
		return mav;
	}
	
	@GetMapping("/webshop/command/delete/{idCommand}")
	public ModelAndView DeleteCommand(@PathVariable("idCommand") Long idCommand) {
		this.commandService.delete(idCommand);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/webshop/command");
		return mav;
	}
	
	@GetMapping("/webshop/command/save/{idCommand}")
	public ModelAndView UpdateCommand(@PathVariable("idCommand") Long idCommand) {
		Command command = this.commandService.getById(idCommand);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/command-save");
		mav.addObject("command",command);
		return mav;
	}
	
	@PostMapping("/webshop/command/save")
	public ModelAndView SaveCommand(@Validated @ModelAttribute("command") Command command, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("command-save");
			mav.addObject("command", command);
			System.out.println("Erreur d'utilisateur, je ne sauvegarde pas.");
			mav.addObject("errorString", "Erreur dans l'utilisateur!!!");
			return mav;
		}else {
		this.commandService.save(command);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/webshop/command");
		mav.addObject("command",command);
		return mav;
		}
	}
	
	@GetMapping("/webshop/command/create")
	public ModelAndView CreateCommand() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/command-save");
		mav.addObject("command",new Command());
		return mav;
	}
	
	
}
