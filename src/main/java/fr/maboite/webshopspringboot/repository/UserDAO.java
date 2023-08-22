package fr.maboite.webshopspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.maboite.webshopspringboot.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer>{
	
	//List<User> findByLoginContainingIgnoreCase(String login);
    List<User> findAllByOrderByIdAsc();
	List<User> findByLoginContainingIgnoreCaseOrderByIdAsc(String login);

}
