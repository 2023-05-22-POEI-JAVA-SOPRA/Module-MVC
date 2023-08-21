package fr.tp.shopi.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import fr.tp.shopi.entity.Article;

@Repository
public interface ArticleDao extends CrudRepository<Article, Long> {

	List<Article> findByDescriptionContaining(String description);
	List<Article> findByBrandIgnoreCaseAndUnitaryPriceBetween(String description,float min, float max);
	
}
