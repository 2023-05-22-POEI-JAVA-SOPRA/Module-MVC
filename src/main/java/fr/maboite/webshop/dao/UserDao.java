package fr.maboite.webshop.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.webshop.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
	
	List<User> findByLoginContainingIgnoreCase(String partLogin);
	
}
