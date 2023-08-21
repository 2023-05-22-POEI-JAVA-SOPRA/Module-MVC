package fr.tpwebshopmvc.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import fr.tpwebshopmvc.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
	public List<User> findByLoginContainingIgnoreCase(String login);


}
