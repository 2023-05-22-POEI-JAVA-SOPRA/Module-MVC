package com.example.demo.fr.webshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.fr.webshop.model.Role;

@Repository
public interface RoleDAO extends CrudRepository<Role, Long> {


	@Query("FROM Role WHERE UPPER(name) LIKE UPPER(:partialName)")
	List<Role> getByNameLike(@Param("partialName") String partialName);
	
}