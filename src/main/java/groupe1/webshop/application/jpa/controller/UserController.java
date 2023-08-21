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
	
//		@GetMapping(path="/users")
//		public String allUser() {
//			System.out.println("Méthode sur /users appelée");
//			return "user";
//		}
//		
//		//Methode appelee lors du chargement de la page planetes.html
//		@ModelAttribute("users")
//		public Iterable<User> listUsers() {
//			return sUser.getAll();
//		}

//		@GetMapping("/users/search")
//		public ModelAndView searchUser(@ModelAttribute("users") PojoLogin login) {
////			ModelAndView mav = new ModelAndView("user", "user", sUser.getByLoginContainingIgnoreCase(login));
//			
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("user");
//			mav.addObject("users", sUser.getByLoginContainingIgnoreCase(login.getLogin()));
////			mav.setViewName("user" +  login.getLogin("login"));
//			
//			System.out.println("recherche par login");
//			return mav;
//		}

		@GetMapping("/users")
		public ModelAndView searchUser(@RequestParam(name="login", required= false) String login) {
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("user");
		    mav.addObject("users", sUser.getByLoginContainingIgnoreCase(login));
		    return mav;
		}
}
