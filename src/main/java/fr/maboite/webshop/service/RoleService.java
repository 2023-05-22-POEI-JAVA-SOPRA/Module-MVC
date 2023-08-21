package fr.maboite.webshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.maboite.webshop.dao.RoleDao;
import fr.maboite.webshop.model.Role;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public Iterable<Role> getAll(){
		return this.roleDao.findAll();
	}
	
	public Optional<Role> getById(Long id) {
		return this.roleDao.findById(id);
	}
	
	public Role save(Role role) {
		return this.roleDao.save(role);
	}
	
	public void delete(Long id) {
		this.roleDao.deleteById(id);
	}

	public List<Role> findByNameContainsIgnoreCase(String partName){
		return this.roleDao.findByNameContainsIgnoreCase(partName);
	}
	
}
