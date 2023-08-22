package groupe1.webshop.application.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import groupe1.webshop.application.jpa.entity.User;
import groupe1.webshop.application.jpa.service.serviceUser;

@Controller
public class UserController {

	@Autowired
	private serviceUser sUser;

//méthode permettant de gérer à la fois l'affichage de toute la liste et la recherche par login
	@GetMapping("/users")
	public ModelAndView searchUser(@RequestParam(name = "login", required = false) String login) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user");
		mav.addObject("users", sUser.getByLoginContainingIgnoreCase(login));
		return mav;
	}

	@PostMapping("/delete-user")
	public String deleteUser(Integer id) {
		sUser.deleteById(id);
		System.out.println("on supprime : " + id);
		return "redirect:/users"; // Redirection sur la page de base
	}
	
	@GetMapping("/user-edit")
	public ModelAndView afficheEditUser(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		User user= sUser.getById(id).get();
		mav.setViewName("userEdit");
		mav.addObject("editedUser", user);
		return mav;
	}
	
	@PostMapping("/user-edit")
	public ModelAndView editUser(@Validated @ModelAttribute("editedUser") User user,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/users"); // nom de la vue (page html)
			mav.addObject("editedUser", user); // nom du model attribute et valeur de l'object
			System.out.println("Erreur d'user, je ne sauvegarde pas.");
			System.out.println(bindingResult);
			mav.addObject("errorString", "Erreur dans l'user !");
			return mav;
		}
		ModelAndView mav = new ModelAndView();
		sUser.save(user);
		System.out.println(user.toString());
		mav.setViewName("redirect:/users"); // nom de la vue (page html)
		mav.addObject("editedUser", user); // nom du mlodel attribute et valeur de l'object
		return mav;
	}
}
