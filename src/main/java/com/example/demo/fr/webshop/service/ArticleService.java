package com.example.demo.fr.webshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.fr.webshop.dao.ArticleDAO;
import com.example.demo.fr.webshop.model.Article;

@Service
public class ArticleService {

	@Autowired
	ArticleDAO articleDAO;
	
	
	

	public List<Article> getAllArticlesBidons() {
		List<Article> articlesBidons = new ArrayList<Article>();
		Article article1 = new Article();
		Article article2 = new Article();
		Article article3 = new Article();
		article1.setId(1l);
		article2.setId(2l);
		article3.setId(3l);
		article1.setDescription("description1");
		article2.setDescription("description2");
		article3.setDescription("description3");
		articlesBidons.add(article1);
		articlesBidons.add(article2);
		articlesBidons.add(article3);
		return articlesBidons;
	}
	
	


	public Article save(Article article) {
		return articleDAO.save(article);
	}
	
	public Article getById(Long id) {
		return articleDAO.findById(id).orElse(null);
	}
	
	public Iterable<Article> getAll() {
		return articleDAO.findAll();
	}
	
	public void delete(Long id) {
		articleDAO.deleteById(id);
	}
	
	
	
	
	
	public List<Article> getByDescriptionLike(String partialDescription){
		String temp = "%"+partialDescription+"%";
		return articleDAO.getByDescriptionLike(temp);
	}
	public List<Article> getByBrandAndUnitaryPriceRange(String brand, Float min, Float max){
		return getByBrandAndUnitaryPriceRange(brand, min, max);
	}
	
	
	
	


}