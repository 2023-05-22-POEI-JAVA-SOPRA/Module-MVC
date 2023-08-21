package groupe1.webshop.application.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.webshop.application.jpa.dao.ArticleDao;
import groupe1.webshop.application.jpa.entity.Article;



@Service
public class serviceArticle {
	
	@Autowired
	private ArticleDao monArticleDao;
	
	public Iterable<Article> getAll(){
		return this.monArticleDao.findAll();
	}
	
	public Optional<Article> getById(Integer id) {
		return this.monArticleDao.findById(id);
	}
	
	public void deleteById(Integer id) {
		this.monArticleDao.deleteById(id);
	}
	
	public List<Article> getByDescriptionContainingIgnoreCase(String description){
		return this.monArticleDao.findByDescriptionContainingIgnoreCase(description);
	}
	
	public List<Article> getByBrandAndPrixRange(String marque, float prixMin, float prixMax){
		return this.monArticleDao.findByMarqueAndPrixRange(marque, prixMin, prixMax);
	}
	
}
