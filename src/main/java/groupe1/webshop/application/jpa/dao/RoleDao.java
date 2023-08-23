package groupe1.webshop.application.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import groupe1.webshop.application.jpa.entity.Role;



/**
 * 
 */
@Repository
public interface RoleDao extends CrudRepository<Role,Integer>{

	/**
	 * @param nom
	 * @return
	 */
	List<Role> findByNameIgnoreCaseContaining(String nom);

}
