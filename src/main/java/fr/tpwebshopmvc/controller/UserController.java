package fr.tpwebshopmvc.controller;

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

import fr.tpwebshopmvc.model.User;
import fr.tpwebshopmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ModelAndView showUsers() {
		System.out.println("users ");
		List<User> allusers = userService.getAll();
		return new ModelAndView("users", "users", allusers);
	}

	@GetMapping("/users/search") // http://localhost:8080/tpwebshopmvc/users/search?searchByLogin=rip
	public ModelAndView filterUserRequestParam(@RequestParam("searchByLogin") String login) {
		System.out.println("users filter by login ");
		List<User> usersFiltered = userService.getByLoginLike(login);
		return new ModelAndView("users", "users", usersFiltered);
	}

	@GetMapping("/users/search/{searchByLogin}") // http://localhost:8080/tpwebshopmvc/users/search/rip
	public ModelAndView filterUserPathParam(@PathVariable("searchByLogin") String login) {
		System.out.println("users filter by login ");
		List<User> usersFiltered = userService.getByLoginLike(login);
		return new ModelAndView("users", "users", usersFiltered);
	}

	@GetMapping("/users/delete") // http://localhost:8080/tpwebshopmvc/users/delete?id=1
	public ModelAndView deleteUser(@RequestParam("id") Integer id) {
		System.out.println("users delete by id : " + id);
		userService.deleteById(id);
		return new ModelAndView("redirect:/users");
	}

	@GetMapping("/users/update")
	public ModelAndView getUser(@RequestParam("id") Integer id) {
		System.out.println("get users by id : " + id);
		User user = userService.getById(id);
		return new ModelAndView("addUser", "user", user);
	}

	@PostMapping("/users/saveUser")
	public ModelAndView save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("Erreur dans la sauvegarde de l'user");
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.setViewName("addUser");
			mv.addObject("errorString", "Erreur dans la sauvegarde de l'utilisateur");
			return new ModelAndView("addUser", "user", user);
		} else {
			userService.saveUser(user);
		}
		return new ModelAndView("redirect:/users");
	}

}
