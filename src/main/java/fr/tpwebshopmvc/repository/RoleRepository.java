package fr.tpwebshopmvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.tpwebshopmvc.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	public List<Role> findByRoleNameContainingIgnoreCase(String roleName);

	public Role findByRoleName(String roleName);
	public List<Role>  findAllByRoleName(String roleName);

}