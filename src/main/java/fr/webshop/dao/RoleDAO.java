package fr.webshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.webshop.model.Role;

@Repository
public interface RoleDAO extends CrudRepository<Role, Long> {


	@Query("FROM Role WHERE name CONTAINS :partialName")
	List<Role> getByNameLike(@Param("partialName") String partialName);
	
}