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
	
	/*
	 * si descr == null afficher tout les éléments cf. articleController
	 */
	public Iterable<Article> getByDescr(String descr){
		//System.out.println(descr);
		return this.monArticleDao.findByDescriptionContainingIgnoreCase(descr);			
	}
	
	public Optional<Article> getById(Integer id) {
		return this.monArticleDao.findById(id);
	}
	
	public void deleteById(Integer id) {
		this.monArticleDao.deleteById(id);
	}
	
	//A supprimer
	public List<Article> getByDescriptionContainingIgnoreCase(String description){
		return this.monArticleDao.findByDescriptionContainingIgnoreCase(description);
	}
	
	public List<Article> getByBrandAndPrixRange(String marque, float prixMin, float prixMax){
		return this.monArticleDao.findByMarqueAndPrixRange(marque, prixMin, prixMax);
	}
	
	public Article save(Article article) {
		return this.monArticleDao.save(article);
	}
	
}
