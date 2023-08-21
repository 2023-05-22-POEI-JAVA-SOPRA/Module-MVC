package fr.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.webshop.dao.ArticleDAO;
import fr.webshop.model.Article;

@Service
public class ArticleService {

	@Autowired
	ArticleDAO articleDAO;
	
	
	
	


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
		if(partialDescription.length()<3) {
			return null;
		} else {
			return getByDescriptionLike(partialDescription);
		}
	}
	public List<Article> getByBrandAndUnitaryPriceRange(String brand, Float min, Float max){
		return getByBrandAndUnitaryPriceRange(brand, min, max);
	}
	
	
	
	


}