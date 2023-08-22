package fr.tpwebshopmvc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.tpwebshopmvc.model.Article;

@SpringBootTest
public class ArticleServiceTest {
	
	@Autowired
	private ArticleService service;
	
	@Test
	public void test_service_not_null() {
		
		Assertions.assertNotNull(service);
		
	}
	
	@Test
	public void test_service_get_all_not_null() {
		
		Assertions.assertNotNull(service.findAll());
		
	}
	
	@Test
	public void test_service_existing_get_by_id_not_null() {
		
		Assertions.assertNotNull(service.findById(5));
		
	}
	
	@Test
	public void test_service_not_existing_get_by_id_null() {
		
		Assertions.assertNull(service.findById(-1));
		
	}
	
	@Test
	public void test_service_save_work() {
		
		Article a = new Article();
		
		a.setDescription("Test");
		a.setBrand("Test");
		a.setUnitaryPrice(25.5);
		
		Assertions.assertNotNull(service.save(a));
		
	}
}
