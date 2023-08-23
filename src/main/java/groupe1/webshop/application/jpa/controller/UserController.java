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
	/**
	 * @param login
	 * @return
	 */
	@GetMapping("/users")
	public ModelAndView searchUser(@RequestParam(name = "login", required = false) String login) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user");
		mav.addObject("users", sUser.getByLoginContainingIgnoreCase(login));
		return mav;
	}

	/**
	 * @param id
	 * @return
	 */
	@PostMapping("/delete-user")
	public String deleteUser(Integer id) {
		sUser.deleteById(id);
		System.out.println("on supprime : " + id);
		return "redirect:/users"; // Redirection sur la page de base
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping({ "/user-edit", "/user-create" })
	public ModelAndView afficheUserForm(@RequestParam(required = false) Integer id) {
		ModelAndView mav = new ModelAndView("userForm");
//        User user = (id != null) ? sUser.getById(id).orElseThrow(() -> new IllegalArgumentException("User not found")) : new User();
		if (id != null) {
			User user = sUser.getById(id).get();
			mav.addObject("user", user);
			mav.addObject("formAction", "/user-edit");
			mav.addObject("editMode", true);
		} else {
			User user = new User();
			mav.addObject("user", user);
			mav.addObject("formAction", "/user-create");
			mav.addObject("editMode", false);
		}

		return mav;
	}

	/**
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@PostMapping({ "/user-edit", "/user-create" })
	public ModelAndView saveUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		String formAction = (user.getIdUser() != null) ? "/user-edit" : "/user-create";
		boolean editMode = (user.getIdUser() != null);
		mav.setViewName("userForm");
		if (bindingResult.hasErrors()) {
			mav.addObject("user", user);
			mav.addObject("editMode", editMode);

			System.out.println("Erreur" + (editMode ? " d'édition" : " de création") + " de l'user, non enregistré !");
			System.out.println(bindingResult);
			mav.addObject("errorString",
					"Erreur lors de la " + (editMode ? "modification" : "création") + " de l'utilisateur");
			return mav;
		}

		sUser.save(user);
		System.out.println(user.toString());
		mav.setViewName("redirect:/users");
		mav.addObject("user", user);
		return mav;
	}

//	@GetMapping("/user-edit")
//	public ModelAndView afficheEditUser(@RequestParam Integer id) {
//		ModelAndView mav = new ModelAndView("userForm");
//		User user = sUser.getById(id).get();
//		mav.addObject("formAction", "/user-edit");
//		mav.addObject("editMode", true);
//		mav.addObject("user", user);
//		return mav;
//	}
//
//	@PostMapping("/user-edit")
//	public ModelAndView editUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("redirect:/users"); // nom de la vue (page html)
//			mav.addObject("user", user); // nom du model attribute et valeur de l'object
//			System.out.println("Erreur d'user, je ne sauvegarde pas.");
//			System.out.println(bindingResult);
//			mav.addObject("errorString", "Erreur dans l'user !");
//			return mav;
//		}
//		ModelAndView mav = new ModelAndView();
//		sUser.save(user);
//		System.out.println(user.toString());
//		mav.setViewName("redirect:/users"); // nom de la vue (page html)
//		mav.addObject("user", user); // nom du mlodel attribute et valeur de l'object
//		return mav;
//	}
//
//	@GetMapping("/user-create")
//	public ModelAndView afficheSaveUser() {
//		ModelAndView mav = new ModelAndView("userForm");
//		User user = new User();
//		mav.addObject("formAction", "/user-create");
//		mav.addObject("editMode", false);
//		mav.addObject("user", user);
//		return mav;
//	}
//	
//	@PostMapping("/user-create")
//	public ModelAndView saveUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("redirect:/users");
//			mav.addObject("user", user);
//			System.out.println("Erreur d'user, non enregistré !");
//			System.out.println(bindingResult);
//			mav.addObject("errorString", "Erreur lors de la création de l'user");
//			return mav;
//		}
//		ModelAndView mav = new ModelAndView();
//		sUser.save(user);
//		System.out.println(user.toString());
//		mav.setViewName("redirect:/users"); // nom de la vue (page html)
//		mav.addObject("user", user); // nom du mlodel attribute et valeur de l'object
//		return mav;
//	}
}
