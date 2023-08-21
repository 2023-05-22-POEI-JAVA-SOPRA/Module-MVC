package fr.tp.shopi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tp.shopi.entity.Role;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public RoleService(RoleDao roleDao) {

		this.roleDao = roleDao;
	}

	public RoleService() {
		// TODO Auto-generated constructor stub
	}

	public void save(Role entity) {
		roleDao.save(entity);
	}

	public Optional<Role> findById(Long id) {
		return roleDao.findById(id);
	}

	public Iterable<Role> findAll() {
		return roleDao.findAll();
	}

	public void deleteById(Long id) {
		roleDao.deleteById(id);
	}

	public void delete(Role entity) {
		roleDao.delete(entity);
	}
	
	public List<Role> findByNameContainingIgnoreCase(String name){
		return this.roleDao.findByNameContainingIgnoreCase(name);
	}

}
