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
	public ModelAndView filterUserRequestParam(@RequestParam("searchByLogin") String searchByLogin) {
		System.out.println("users filter by login ");
		List<User> usersFiltered = userService.getByLoginLike(searchByLogin);
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users");
		mv.addObject("searchByLogin", searchByLogin);
		mv.addObject("users", usersFiltered);
		
		return mv;
	}

	@GetMapping("/users/search/{searchByLogin}") // http://localhost:8080/tpwebshopmvc/users/search/rip
	public ModelAndView filterUserPathParam(@PathVariable("searchByLogin") String searchByLogin) {
		System.out.println("users filter by login ");
		List<User> usersFiltered = userService.getByLoginLike(searchByLogin);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users");
		mv.addObject("searchByLogin", searchByLogin);
		mv.addObject("users", usersFiltered);
		return mv;
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
		 User userInDb = userService.getById(id);
		return new ModelAndView("updateUser", "user", userInDb);
	}

	@GetMapping("/users/create")
	public ModelAndView showFormUser() {
		User emptyUser = new User();
		return new ModelAndView("addUser","user",emptyUser);
	}

	@PostMapping("/users/updateUser")
	public ModelAndView update(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
		System.out.println("update user : " + user);
		// User user = userService.getById(id);
		if (bindingResult.hasErrors()) {
			System.out.println("Erreur dans l'update  de l'user");
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.setViewName("updateUser");
			mv.addObject("errorString", "Erreur dans la sauvegarde de l'utilisateur");
			return mv;
		} else {
			userService.updateUser(user);
			System.out.println("User with id " + user.getIdUser() + " updated");
		}
		return new ModelAndView("redirect:/users");

	}

	@PostMapping("/users/saveUser")
	public ModelAndView save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("Erreur dans la sauvegarde de l'user");
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.setViewName("addUser");
			mv.addObject("errorString", "Erreur dans la sauvegarde de l'utilisateur");
			return mv;
		} else {
			System.out.println("Save user");
			userService.saveUser(user);
		}
		return new ModelAndView("redirect:/users");
	}

}