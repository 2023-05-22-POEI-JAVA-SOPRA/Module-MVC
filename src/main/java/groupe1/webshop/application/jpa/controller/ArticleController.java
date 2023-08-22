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

	// PAGE article.html
	@GetMapping(path = "/articles")
	public ModelAndView searchArticles(@RequestParam(name="recherche",required=false)String descr) {
		System.out.println("Méthode sur /articles appelée");
		// return des articles pour planetes.html (cf. config pour prefix/suffix)
		ModelAndView mav=new ModelAndView();
		mav.setViewName("article");
		if(descr==null) {
			//System.out.println("descr null");
			mav.addObject("maListeArticle", artServ.getAll());
			return mav;
		}
		else {	
			System.out.println("descr panul");
			mav.addObject("maListeArticle", artServ.getByDescr(descr));
			return mav;
		}
	}
	

	@PostMapping("/delete-article")
	public String deleteArticle(Integer id) {
		artServ.deleteById(id);
		System.out.println("on supprime : " + id);
		return "redirect:/articles"; // Redirection sur la page de base
	}
	
	// PAGE EDIT ARTICLE
	
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
	
	@GetMapping("/article-create")
	public ModelAndView afficheCreateArticle() {
		ModelAndView mav = new ModelAndView();
		Article newArticle = new Article();
		mav.setViewName("articleCreate");
		mav.addObject("newArticle", newArticle);
		return mav;
	}
	
	// PAGE CREATE ARTICLE
	@PostMapping("/article-create")
	public ModelAndView createArticle(@Validated @ModelAttribute("createArticle") Article newArticle
			,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/articles"); // nom de la vue (page html)
			mav.addObject("newArticle", newArticle); // nom du mlodel attribute et valeur de l'object
			System.out.println("Erreur creation article, je ne cree pas.");
			mav.addObject("errorString", "Erreur dans la creation de l'article !");
			return mav;
		}
		ModelAndView mav = new ModelAndView();
		artServ.save(newArticle);
		mav.setViewName("redirect:/articles");
		mav.addObject("newArticle", newArticle); // nom du model attribute et valeur de l'object
		return mav;

	}

}
