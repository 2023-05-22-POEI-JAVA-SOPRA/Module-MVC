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

import groupe1.webshop.application.jpa.entity.Article;
import groupe1.webshop.application.jpa.service.serviceArticle;

@Controller
public class ArticleController {

	@Autowired
	private serviceArticle artServ;

	// GESTION DE LA PAGE planetes.html
	@GetMapping(path = "/articles")
	public String allArticles() {
		System.out.println("Méthode sur /articles appelée");
		// return du planetes pour planetes.html (cf. config pour prefix/suffix)
		return "article";
	}

	// Methode appelee lors du chargement de la page planetes.html
	@ModelAttribute("maListeArticle")
	public Iterable<Article> maListeArticle() {
		return artServ.getAll();
	}

	@PostMapping("/delete-article")
	public String deleteArticle(Integer id) {
		artServ.deleteById(id);
		System.out.println("on supprime : " + id);
		return "redirect:/articles"; // Redirection sur la page de base
	}
	
	@GetMapping("/article-edit")
	public ModelAndView afficheEditArticle(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Article article = artServ.getById(id).get();
		mav.setViewName("articleEdit");
		mav.addObject("editedArticle", article);
		return mav;
	}
	
	@PostMapping("/article-edit")
	public ModelAndView editArticle(@Validated @ModelAttribute("editedArticle") Article article,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/articles"); // nom de la vue (page html)
			mav.addObject("editedArticle", article); // nom du mlodel attribute et valeur de l'object
			System.out.println("Erreur de article, je ne sauvegarde pas.");
			mav.addObject("errorString", "Erreur dans la article !");
			return mav;
		}
		ModelAndView mav = new ModelAndView();
		artServ.save(article);
		System.out.println(article.toString());
		mav.setViewName("redirect:/articles"); // nom de la vue (page html)
		mav.addObject("editedArticle", article); // nom du mlodel attribute et valeur de l'object
		return mav;
	}

}
