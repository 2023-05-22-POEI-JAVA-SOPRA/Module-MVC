package com.example.demo.fr.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.fr.webshop.model.Article;
import com.example.demo.fr.webshop.service.ArticleService;


@Controller
public class ArticleController {


	@Autowired
	ArticleService articleService;
	

	
	@GetMapping(path = {"/articles", "/articles.html"})
	public ModelAndView afficheArticles(@RequestParam(value = "partialDescription", required = false) String partialDescription) {
		System.out.println("J'affiche la page articles");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("articles");
		
		if(partialDescription == null) {
			mav.addObject("articles", articleService.getAll());
			return mav;
		} else {
			mav.addObject("articles", articleService.getByDescriptionLike(partialDescription));
			return mav;
		}
	}
	
	
	@RequestMapping(path = "/articles/{id}")
	public ModelAndView deleteArticle(@PathVariable(value = "id") Long id) {
		System.out.println("Méthode deleteArticle appelée");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/articles");
		 
		articleService.delete(id);
		
		return mav;
	}
	
	
	@GetMapping(path = "/articles/register/{id}")
	public ModelAndView updateArticle(@PathVariable(value = "id") Long id) {
		System.out.println("Méthode updateArticle appelée");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerArticle");

		mav.addObject("article", articleService.getById(id));
		
		mav.addObject("save", false);
		return mav;
	}	
	
	
	@GetMapping(path = "/articles/register")
	public ModelAndView addArticle() {
		System.out.println("Méthode addArticle appelée");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerArticle");

		mav.addObject("save", true);	
		return mav;
	}
	
	
	@PostMapping(path = "/articles/register")
	public ModelAndView saveArticle(@ModelAttribute("article") Article article) {
		System.out.println("Méthode saveArticle appelée");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/articles");
		
		articleService.save(article);
	
		return mav;
	}
	
	
}
