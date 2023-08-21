package fr.tp.shopi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tp.shopi.entity.Article;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	

	public ArticleService() {
		
	}

	public ArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public ArticleService(ArticleDao articleDao) {
		
		this.articleDao = articleDao;
	}

	public void  save(Article entity) {
		articleDao.save(entity);
	}

	public Optional<Article> findById(Long id) {
		return articleDao.findById(id);
	}

	public Iterable<Article> findAll() {
		return articleDao.findAll();
	}

	public void deleteById(Long id) {
		articleDao.deleteById(id);
	}

	public void delete(Article entity) {
		articleDao.delete(entity);
	}
	
	public List<Article> findByDescriptionContaining(String description){
		return this.articleDao.findByDescriptionContaining(description);
	}
	
	public List<Article> findByBrandIgnoreCaseAndUnitaryPriceBetween(String description,float min, float max){
		return this.articleDao.findByBrandIgnoreCaseAndUnitaryPriceBetween(description, min, max);
	}
	

}
