package fr.maboite.webshopspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.maboite.webshopspringboot.dto.UserDTO;
import fr.maboite.webshopspringboot.model.User;
import fr.maboite.webshopspringboot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService us;
	
	
	
	//--/users==================================================================
	@GetMapping("/users")
	public ModelAndView getUserHome(@RequestParam(value="search", required=false) String search) {
		List<User> uList;
		ModelAndView mav = new ModelAndView("user-home");
		if (search == null || search.length() < 1)
			uList = (List<User>) us.getAllOrderByIdAsc();
		else
			uList =us.getByLoginLikeIgnoreCaseOrderByIdAsc(search);	
		
		mav.addObject("userList", UserDTO.convertListToDTO(uList));
		return mav;
	}
	
	//--/user===================================================================
	@GetMapping("/user")
	public ModelAndView getUserDetails(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("user-details");
		User u = us.getById(id);
		UserDTO userDto = new UserDTO(u);
		mav.addObject("user", userDto);
		return mav;
	}
	
	
	@PostMapping("/user")
	public ModelAndView postUserDetails(@Validated @ModelAttribute("user") UserDTO userDto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println(userDto);
		
		if (result.hasErrors()) {
			mav.setViewName("user-details");
			mav.addObject("user", userDto);
			return mav;
		}
		
		User user = userDto.convertToUser();
		us.update(user);
		mav.setViewName("redirect:/users");
		return mav;
	}
	
	//--/user-delete=============================================================
	@GetMapping("/user-delete")
	public ModelAndView deleteUser(@RequestParam("id") Integer id) {
		us.deleteById(id);
		ModelAndView mav = new ModelAndView("redirect:/users");
		return mav;
	}
	
	//--/user-create===============================================================
	@GetMapping("/user-create")
	public ModelAndView createUser() {
		return new ModelAndView("user-create");
	}
	
	@PostMapping("/user-create")
	public ModelAndView postCreateUser(@Validated @ModelAttribute("user") UserDTO userDto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			mav.setViewName("user-create");
			mav.addObject("user", userDto);
			return mav;
		}
		User u = userDto.convertToUser();
		us.save(u);
		mav.setViewName("redirect:/users");
		return mav;
	}
}
