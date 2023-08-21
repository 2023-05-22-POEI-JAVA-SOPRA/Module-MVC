package fr.tpwebshopmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.tpwebshopmvc.model.User;
import fr.tpwebshopmvc.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ModelAndView showUsers()
	{
		System.out.println("users ");
		List<User> allusers = userService.getAll();
		return new ModelAndView("users","users",allusers);
	}
	

	@GetMapping("/users/login")
	public ModelAndView filterUser(@RequestParam("login") String login )
	{
		System.out.println("users filter by login ");
		List<User> usersFiltered = userService.getByLoginLike(login);
		return new ModelAndView("users","users",usersFiltered);
	}
	
}
