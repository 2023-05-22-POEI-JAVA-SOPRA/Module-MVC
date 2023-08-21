package groupe1.webshop.application.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import groupe1.webshop.application.jpa.entity.Article;
import groupe1.webshop.application.jpa.service.serviceArticle;


@Controller
public class ArticleController {
	
	@Autowired
	private serviceArticle artServ;
	
	// GESTION DE LA PAGE planetes.html
		@GetMapping(path="/articles")
		public String allArticles() {
			System.out.println("Méthode sur /articles appelée");
			//return du planetes pour planetes.html (cf. config pour prefix/suffix)
			return "article";
		}
		
		//Methode appelee lors du chargement de la page planetes.html
		@ModelAttribute("maListeArticle")
		public Iterable<Article> maListeArticle() {
			return artServ.getAll();
		}
		
		@PostMapping("/delete-article")
		public String deleteArticle(Integer id) {
		    artServ.deleteById(id);
			System.out.println("on supprime : "+id);
		    return "redirect:/articles"; // Redirection sur la page de base
		}

	
}
