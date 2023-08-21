package fr.tpwebshopmvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.tpwebshopmvc.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findAll();

	public Optional<User> findById(Integer id);

	public List<User> findByLoginContainingIgnoreCase(String login);

	public void deleteById(Integer id);
}
