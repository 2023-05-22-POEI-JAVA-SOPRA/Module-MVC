package groupe1.webshop.application.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.webshop.application.jpa.dao.RoleDao;
import groupe1.webshop.application.jpa.entity.Role;



@Service
public class serviceRole {
	
	@Autowired
	RoleDao monRoleDao;
	
	/**
	 * @return
	 */
	public Iterable<Role> getAll() {
		return this.monRoleDao.findAll();
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Optional<Role> getById(Integer id) {
		return this.monRoleDao.findById(id);
	}
	
	/**
	 * @param role
	 * @return
	 */
	public Role save(Role role) {
		return this.monRoleDao.save(role);
	}
	
	/**
	 * @param id
	 */
	public void deleteById(Integer id) {
		this.monRoleDao.deleteById(id);
	}
	
	/**
	 * @param nom
	 * @return
	 */
	public List<Role> getByNameIgnoreCaseContaining(String nom){
		return this.monRoleDao.findByNameIgnoreCaseContaining(nom);
	}

	/**
	 * @param descr
	 * @return
	 */
	public Object getByRoleName(String descr) {
		return this.monRoleDao.findByNameIgnoreCaseContaining(descr);
	}

}
