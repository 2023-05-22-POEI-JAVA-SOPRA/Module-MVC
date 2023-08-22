package groupe1.webshop.application.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import groupe1.webshop.application.jpa.service.serviceUser;

@Controller
public class UserController {

	@Autowired
	private serviceUser sUser;
	
//méthode permettant de gérer à la fois l'affichage de toute la liste et la recherche par login
	@GetMapping("/users")
	public ModelAndView searchUser(@RequestParam(name="login", required= false) String login) {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("user");
	    mav.addObject("users", sUser.getByLoginContainingIgnoreCase(login));
	    return mav;
	}
}
