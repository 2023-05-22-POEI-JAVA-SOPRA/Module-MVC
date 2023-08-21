package fr.tp.shopi.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.tp.shopi.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	List<User> findByPassword(String password);
	List<User> findByLogin(String Login);
	List<User> findByLoginAndPassword(String Login, String password);
	
}
