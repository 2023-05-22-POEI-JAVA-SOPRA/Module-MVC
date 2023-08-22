package fr.tp.shopifinal.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.tp.shopifinal.entity.Role;


@Repository
public interface RoleDao extends CrudRepository<Role, Long>{
	
	List<Role> findByNameContainingIgnoreCase(String name);

}
