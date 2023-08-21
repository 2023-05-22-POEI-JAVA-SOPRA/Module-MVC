package fr.tpwebshopmvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.tpwebshopmvc.model.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
	
	public List<Article> findByDescriptionContainingIgnoreCase(String filtre);
	
}
