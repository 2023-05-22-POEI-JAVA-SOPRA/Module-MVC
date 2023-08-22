package fr.maboite.webshopspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.maboite.webshopspringboot.model.Article;
import fr.maboite.webshopspringboot.service.ArticleService;
import jakarta.validation.Valid;

@Controller
public class ArticleController {

	private ArticleService articleservice;

	@Autowired
	public ArticleController(ArticleService articleservice) {
		this.articleservice = articleservice;
	}

	@GetMapping("/articles")
	public String listArticles(Model model, @RequestParam(value = "searchName", required = false) String searchName) {
		List<Article> articles;

		if (searchName != null && !searchName.isEmpty()) {
			articles = articleservice.getByDescription(searchName);
			

		} else {
			articles = articleservice.getAllArticles();
		}

		model.addAttribute("articles", articles);
		model.addAttribute("searchName", searchName);

		return "articles";
	}

	@GetMapping("/article/create")
	public String showCreateArticleForm(Model model) {
		model.addAttribute("article", new Article());
		return "article-create";
	}

	@GetMapping("/article/edit/{id}")
	public String showEditArticleForm(@PathVariable Integer id, Model model) {
		Article article = articleservice.getById(id);
		model.addAttribute("article", article);
		return "article-edit";
	}

	@GetMapping("/article/delete/{id}")
	public String showDeleteArticleForm(@PathVariable Integer id, Model model) {
		Article article = articleservice.getById(id);
		model.addAttribute("article", article);
		return "article-delete";
	}

	@PostMapping("/article/delete/{id}")
	public String deleteArticle(@PathVariable Integer id) {
		articleservice.deleteArticle(id);
		return "redirect:/article";
	}

	@PostMapping("/article")
	public String saveArticle(@Valid @ModelAttribute("article") Article article, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("Erreurs de validation détectées.");
			return "article-create";
		} else {
			articleservice.saveArticle(article);
			return "redirect:/articles";
		}

	}

}
