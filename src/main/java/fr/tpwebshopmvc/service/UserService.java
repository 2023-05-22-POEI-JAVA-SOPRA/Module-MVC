package fr.tpwebshopmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.tpwebshopmvc.model.User;
import fr.tpwebshopmvc.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAll()
	{
		return userRepository.findAll();
	}
	public User getById(Integer id)
	{
		return userRepository.findById(id).orElse(null);
	}
	public List<User> getByLoginLike(String login)
	{
		return userRepository.findByLoginContainingIgnoreCase(login);
	}
	
	public void deleteById(Integer id)
	{
		 userRepository.deleteById(id);
	}
	
	public void saveUser(User user)
	{
		userRepository.save(user);
	}
	
	public void updateUser(User user)
	{
		userRepository.save(user);
	}
	
}