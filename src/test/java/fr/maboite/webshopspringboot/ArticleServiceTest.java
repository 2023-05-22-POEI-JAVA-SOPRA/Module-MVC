package fr.maboite.webshopspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.webshopspringboot.model.Article;
import fr.maboite.webshopspringboot.service.ArticleService;

@SpringBootTest
class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;

	@BeforeEach
	public void setup() {

		List<Article> articles = articleService.getAllArticles();

		for (Article article : articles) {

			articleService.deleteArticle(article.getId());

		}

	}

	@Test
	public void testGetAllArticles() {

		Article article1 = new Article();

		article1.setDescription("good");
		article1.setBrand("lg");
		article1.setUnitaryPrice(150);

		Article article2 = new Article();
		article2.setDescription("not good");
		article2.setBrand("nokia");
		article2.setUnitaryPrice(50);

		articleService.saveArticle(article1);

		articleService.saveArticle(article2);

		List<Article> articles = articleService.getAllArticles();

		assertEquals(2, articles.size());

		assertEquals("good", articles.get(0).getDescription());

		assertEquals("not good", articles.get(1).getDescription());

	}

}
