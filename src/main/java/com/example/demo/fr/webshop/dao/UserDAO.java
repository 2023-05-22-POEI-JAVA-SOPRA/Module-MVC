package com.example.demo.fr.webshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.fr.webshop.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

	

	List<User> findByLoginAndPassword(String login, String password);
	List<User> findByLogin(String login);

	@Query("FROM User WHERE UPPER(login) LIKE UPPER(:partialLogin)")
	List<User> getByLoginLike(@Param("partialLogin") String partialLogin);
}
