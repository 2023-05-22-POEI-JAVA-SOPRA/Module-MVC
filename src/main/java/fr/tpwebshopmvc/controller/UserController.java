package fr.tpwebshopmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	
	@GetMapping("/users/{searchByLogin}") // http://localhost:8080/tpwebshopmvc/users/rip
	public ModelAndView filterUserPathParam(@PathVariable("searchByLogin") String login) {
		System.out.println("users filter by login ");
		List<User> usersFiltered = userService.getByLoginLike(login);
		return new ModelAndView("users", "users", usersFiltered);
	}
	@GetMapping("/users/delete")
	public ModelAndView deleteUser(@RequestParam("id") Integer id) {
		System.out.println("users delete by id : " + id);
		userService.deleteById(id);
		return new ModelAndView("redirect:/users");
	}

}
