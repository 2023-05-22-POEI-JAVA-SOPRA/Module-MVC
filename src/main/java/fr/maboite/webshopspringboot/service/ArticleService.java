package fr.maboite.webshopspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maboite.webshopspringboot.model.Article;
import fr.maboite.webshopspringboot.repository.ArticleDao;

@Service
public class ArticleService {

	private final ArticleDao articleDao;

	@Autowired
	public ArticleService(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public List<Article> getAllArticles() {

		return articleDao.findAll();
	}

	public List<Article> getByDescription(String Description) {
		// TODO Auto-generated method stub
		return articleDao.findByDescription(Description);

	}
	
	

	public List<Article> getByBrand(String Brand) {
		// TODO Auto-generated method stub
		return articleDao.findByBrand(Brand);

	}

	public Article getById(int id) {
		// TODO Auto-generated method stub
		return articleDao.findById(id).get();

	}

	public Article saveArticle(Article article) {
		return articleDao.save(article);
	}

	public void deleteArticle(Integer id) {
		articleDao.deleteById(id);
	}

}
