package groupe1.webshop.application.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import groupe1.webshop.application.jpa.entity.Article;

@Repository
public interface ArticleDao extends CrudRepository<Article,Integer>{
	
	//@Query("from Article where LENGTH(description) >= 3 AND LOWER(description) LIKE %:description%")
	List<Article> findByDescriptionContainingIgnoreCase(String description);
	
	//Ancienne query 
//	@Query("from Article where LOWER(:marque) = LOWER(:marque) AND unitaryprice BETWEEN :prixMin AND :prixMax")
	@Query("from Article where LOWER(:marque) = LOWER(brand) AND price BETWEEN :prixMin AND :prixMax")
	List<Article> findByMarqueAndPrixRange(@Param("marque") String marque, @Param("prixMin") Float prixMin, @Param("prixMax") Float prixMax);
	
}