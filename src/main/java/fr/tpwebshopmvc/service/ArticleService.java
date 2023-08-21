package fr.tpwebshopmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tpwebshopmvc.model.Article;
import fr.tpwebshopmvc.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository repository;
	
	
	public List<Article> findAll()
	{
		return (List<Article>) repository.findAll();
	}
	
	public Article findById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Article save(Article article) {
		return repository.save(article);
	}
	
	public void delete(Article article) {
		repository.delete(article);
	}
}
