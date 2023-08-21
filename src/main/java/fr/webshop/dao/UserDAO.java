package fr.webshop.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.webshop.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

	

	List<User> findByLoginAndPassword(String login, String password);
}
