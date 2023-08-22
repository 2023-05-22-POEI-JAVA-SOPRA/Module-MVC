package fr.tpwebshopmvc.controller;

import java.util.List;

import org.hibernate.query.results.ResultSetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.tpwebshopmvc.model.Article;
import fr.tpwebshopmvc.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/articles")
	public ModelAndView showArticles()
	{
		System.out.println("articles ");
		
		List<Article> allArticles = articleService.findAll();
		
		return new ModelAndView("articles","articles",allArticles);
	}
	
	@GetMapping("/filtre-articles")
	public ModelAndView filtreArticles(@RequestParam String filtre)
	{
		System.out.println("articles ");
		ModelAndView mav = new ModelAndView("articles");
		List<Article> allArticles = articleService.filtre(filtre);
		
		mav.addObject("filtre", filtre);
		mav.addObject("articles", allArticles);
		
		return mav;
	}
	
	@GetMapping("/ajouter-article")
	public ModelAndView getAddArticle() {
		return new ModelAndView("addArticles");
	}
	
	@PostMapping("/article")
	public ModelAndView addArticle(@Validated @ModelAttribute Article article, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
		{
			ModelAndView mav = new ModelAndView("addArticles");
			mav.addObject("error", bindingResult);
			
			mav.addObject("article", article);
			
			return mav;
		}
		
		articleService.save(article);
		
		
		return new ModelAndView("redirect:/articles");
	}
	
	@GetMapping("/put-article/{id}")
	public ModelAndView getPutArticle(@PathVariable(name = "id") Integer id) {
		ModelAndView mav= new ModelAndView("putArticle");
		Article article = articleService.findById(id);
		
		mav.addObject("article", article);
		
		return mav;
	}
	
	@PostMapping("/article/{id}")
	public ModelAndView putArticle(@PathVariable(name = "id") Integer id ,@Validated @ModelAttribute Article article, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
		{
			ModelAndView mav = new ModelAndView("addArticles");
			mav.addObject("error", bindingResult);
			
			mav.addObject("article", article);
			
			return mav;
		}
		
		article.setIdArticle(id);
		
		articleService.save(article);
		
		return new ModelAndView("redirect:/articles");
	}
	
	@GetMapping("/article/{id}")
	public String deleteArticles(@PathVariable(name = "id") Integer id)
	{
		System.out.println("delete article " + id);
		Article article = articleService.findById(id);
		
		articleService.delete(article);
		
		return "redirect:/articles";
	}
}
