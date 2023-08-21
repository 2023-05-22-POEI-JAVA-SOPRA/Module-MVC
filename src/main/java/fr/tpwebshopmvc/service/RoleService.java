package fr.tpwebshopmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tpwebshopmvc.model.Role;
import fr.tpwebshopmvc.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	public Iterable<Role> findAll() {
		return repository.findAll();
	}

	public Role findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Role save(Role role) {
		return repository.save(role);
	}

	public void delete(Role role) {
		repository.delete(role);
	}

	public Iterable<Role> getByRoleNameLike(String roleName) {
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
