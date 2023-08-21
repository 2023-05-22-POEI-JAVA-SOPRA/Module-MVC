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
	public List<User> getByLoginLike(String login)
	{
		return userRepository.findByLoginContainingIgnoreCase(login);
	}
	

}
