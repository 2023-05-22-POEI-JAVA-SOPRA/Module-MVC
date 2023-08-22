package com.example.demo.fr.webshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.fr.webshop.model.Article;

public class ArticleServiceTest {

	@Autowired
	ArticleService articleService;
	

	
	@Test
	public void testCorrespondingDaoExists() {
		Assertions.assertNotNull(articleService.articleDAO);
	}
	
	@Test
	public void testGet() {
		Long idTest = 1l;
		Article articleTest = articleService.articleDAO.findById(idTest).get();

		Assertions.assertEquals(idTest, articleTest.getId());
		Assertions.assertEquals("Souris", articleTest.getDescription());
		Assertions.assertEquals("Logitoch", articleTest.getBrand());
		Assertions.assertEquals(65, articleTest.getUnitaryPrice());
		
		
	}
	
}