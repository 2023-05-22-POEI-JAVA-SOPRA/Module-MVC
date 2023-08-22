package com.example.demo.fr.webshop.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.fr.webshop.model.Article;

@Repository
public interface ArticleDAO extends CrudRepository<Article, Long> {


	@Query("FROM Article WHERE UPPER(description) LIKE UPPER(:partialDescription)")
	List<Article> getByDescriptionLike(@Param("partialDescription") String partialDescription);

	@Query("FROM Article WHERE (UPPER(brand) = UPPER(:brand) and unitaryPrice between :min and :max )")
	List<Article> getByBrandAndUnitaryPriceRange(@Param("brand") String brand, @Param("min") Float min, @Param("max") Float max);
}



