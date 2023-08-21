package fr.tpwebshopmvc.repository;

import org.springframework.data.repository.CrudRepository;

import fr.tpwebshopmvc.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	public Iterable<Role> findByRoleNameContainingIgnoreCase(String roleName);

}
