package fr.tpwebshopmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
