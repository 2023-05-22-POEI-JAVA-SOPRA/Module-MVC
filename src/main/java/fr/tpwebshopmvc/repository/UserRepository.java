package fr.tpwebshopmvc.repository;

import org.springframework.data.repository.CrudRepository;
import fr.tpwebshopmvc.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	
}
