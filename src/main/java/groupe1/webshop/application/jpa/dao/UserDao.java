package groupe1.webshop.application.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import groupe1.webshop.application.jpa.entity.User;

@Repository
public interface UserDao extends CrudRepository<User,Integer>{
	List<User> findAll();

	List<User> findByLoginContainingIgnoreCase(String login);
}