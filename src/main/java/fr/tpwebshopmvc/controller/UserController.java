package fr.tpwebshopmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.tpwebshopmvc.model.User;
import fr.tpwebshopmvc.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	UserService userService;

	@GetMapping("/test")
	public ModelAndView showUsers()
	{
		System.out.println("test ");
		ModelAndView modelAndView = new ModelAndView();
		List<User> allusers = userService.getAll();
		modelAndView.setViewName("users");
	
		modelAndView.addObject("users",allusers );
		
		return modelAndView;
	}
	

}
