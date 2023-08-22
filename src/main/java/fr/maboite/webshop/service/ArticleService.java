package fr.maboite.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maboite.webshop.dao.ArticleDao;
import fr.maboite.webshop.model.Article;

@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	public Iterable<Article> getAll(){
		return this.articleDao.findAll();
	}
	
	public Article getById(Long id) {
		return this.articleDao.findById(id).get();
	}
	
	public Article save(Article article) {
		return this.articleDao.save(article);
	}
	
	public void delete(Long id) {
		this.articleDao.deleteById(id);
	}
	
	public List<Article> findByDescriptionContainsIgnoreCase(String partDescription){
		return this.articleDao.findByDescriptionContainsIgnoreCase(partDescription);
	}

	
}
