package fr.tpwebshopmvc.repository;

import org.springframework.data.repository.CrudRepository;

import fr.tpwebshopmvc.model.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

}
