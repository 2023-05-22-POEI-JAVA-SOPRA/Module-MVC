package fr.maboite.webshopspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import fr.maboite.webshopspringboot.model.Article;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

	//List<Article> findByDescriptionBrandUnitarypriceContainingIgnoreCase(String description, String brand, float unitaryPrice);

	
	
	 // List<Article> findById(int id);
	  
	//  List<Article> findAll();
	  
	  //List<Article> findByBrandContainingIgnoreCase(String brand);
	  List<Article> findByBrand(String brand);
	  
	  //List<Article> findByDescriptionContainingIgnoreCase(String description);
	  List<Article> findByDescription(String description);
	  
	  //List<Article> findByunitaryPriceContainingIgnoreCase(float unitaryPrice);
	  List<Article> findByunitaryPrice(float unitaryPrice);
	 
	  //List<Article> findByDescriptionBrandUnitaryprice(String searchname);


}
