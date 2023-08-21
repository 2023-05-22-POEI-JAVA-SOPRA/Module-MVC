package fr.maboite.webshop.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.webshop.model.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

	List<Role> findByNameContainsIgnoreCase(String partName);
	
}
