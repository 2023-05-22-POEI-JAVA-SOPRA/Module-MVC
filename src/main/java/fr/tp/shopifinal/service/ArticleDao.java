package fr.tp.shopifinal.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.tp.shopifinal.entity.Article;

@Repository
public interface ArticleDao extends CrudRepository<Article, Long> {

	List<Article> findByDescriptionContainingIgnoreCase(String description);
	List<Article> findByBrandIgnoreCaseAndUnitaryPriceBetween(String description,float min, float max);
	
}
