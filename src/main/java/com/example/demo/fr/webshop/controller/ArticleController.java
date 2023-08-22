package com.example.demo.fr.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.fr.webshop.service.ArticleService;


@Controller
public class ArticleController {


	@Autowired
	ArticleService articleService;
	

	
	@GetMapping(path = {"/articles", "/articles.html"})
	public ModelAndView afficheArticles(@RequestParam(value = "partialDescription", required = false) String partialDescription) {
		 System.out.println("J'affiche la page articles");

		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("/articles");
		 
		 if(partialDescription == null) {
			 mav.addObject("articles", articleService.getAll());
			 return mav;
		 } else {
			mav.addObject("articles", articleService.getByDescriptionLike(partialDescription));
			return mav;
		 }
	}
	
	
}
