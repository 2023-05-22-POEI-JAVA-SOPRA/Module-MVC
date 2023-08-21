package fr.tpwebshopmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.tpwebshopmvc.model.Article;
import fr.tpwebshopmvc.model.Role;
import fr.tpwebshopmvc.repository.RoleRepository;

@Service
public class RoleService {
	
	private RoleRepository repository;
	 
	public List<Role> findAll()
	{
		return (List<Role>) repository.findAll();
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
	
}
