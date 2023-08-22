package fr.maboite.webshopspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.maboite.webshopspringboot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	List<Role> findByNameContainingIgnoreCase(String name);
}
