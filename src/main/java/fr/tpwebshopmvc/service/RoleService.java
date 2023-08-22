package fr.tpwebshopmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tpwebshopmvc.model.Role;
import fr.tpwebshopmvc.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	public List<Role> findAll() {
		return (List<Role>) repository.findAll();
	}

	public Role findById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Role getByRoleName(String roleName)
	{
		return repository.findByRoleName(roleName);
	}
	public List<Role> getAllByRoleName(String roleName)
	{
		return repository.findAllByRoleName(roleName);
	}
	public Role save(Role role) {
		return repository.save(role);
	}

	public void delete(Role role) {
		repository.delete(role);
	}

	public List<Role> getByRoleNameLike(String roleName) {
		return repository.findByRoleNameContainingIgnoreCase(roleName);
	}

	public void deleteById(Integer id) {
		 repository.deleteById(id);
	}
	public void updateRole(Role role)
	{
		repository.save(role);
	}
	
}